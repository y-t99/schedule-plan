package cn.yuanyuan.sp.foreground.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.yuanyuan.sp.foreground.dao.SmsScheduleCardDao;
import cn.yuanyuan.sp.foreground.dto.ScheduleCardWithGroupByRow;
import cn.yuanyuan.sp.foreground.dto.ScheduleCardWithRow;
import cn.yuanyuan.sp.foreground.service.SmsScheduleCardService;
import cn.yuanyuan.sp.mbg.mapper.SmsScheduleBaseRowMapper;
import cn.yuanyuan.sp.mbg.mapper.SmsScheduleCardMapper;
import cn.yuanyuan.sp.mbg.model.SmsScheduleBaseRow;
import cn.yuanyuan.sp.mbg.model.SmsScheduleBaseRowExample;
import cn.yuanyuan.sp.mbg.model.SmsScheduleCard;
import cn.yuanyuan.sp.mbg.model.SmsScheduleCardExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static cn.yuanyuan.sp.foreground.constant.ScheduleEnableGroupField.*;

@Service
public class SmsScheduleCardServiceImpl implements SmsScheduleCardService {

    final SmsScheduleCardMapper scheduleCardMapper;
    final SmsScheduleCardDao scheduleCardDao;
    final SmsScheduleBaseRowMapper scheduleBaseRowMapper;
    private final Map<String, Function<SmsScheduleBaseRow, Integer>> getGroupFieldFunction;

    public SmsScheduleCardServiceImpl(SmsScheduleCardMapper scheduleCardMapper, SmsScheduleCardDao scheduleCardDao, SmsScheduleBaseRowMapper scheduleBaseRowMapper) {
        getGroupFieldFunction = new HashMap<>();
        this.scheduleCardMapper = scheduleCardMapper;
        this.scheduleCardDao = scheduleCardDao;
        this.scheduleBaseRowMapper = scheduleBaseRowMapper;
    }

    @PostConstruct
    public void postConstruct() {
        getGroupFieldFunction.put(IsDelay.getField(), SmsScheduleBaseRow::getIsDelay);
        getGroupFieldFunction.put(IsFinish.getField(), SmsScheduleBaseRow::getIsFinish);
        getGroupFieldFunction.put(Priority.getField(), SmsScheduleBaseRow::getPriority);
        getGroupFieldFunction.put(ScheduleFactorCategoryId.getField(), SmsScheduleBaseRow::getScheduleFactorCategoryId);
    }

    @Override
    public ScheduleCardWithRow get(int userId, String cardSn) {
        SmsScheduleCardExample queryCondition = new SmsScheduleCardExample();
        queryCondition.createCriteria().andCardSnEqualTo(cardSn).andUserIdEqualTo(userId);
        // 1. 查找日程卡
        List<SmsScheduleCard> scheduleCards = scheduleCardMapper.selectByExample(queryCondition);
        SmsScheduleCard scheduleCard;
        // 日程卡不存在创建
        if(scheduleCards.size() == 0) {
            scheduleCard = new SmsScheduleCard();
            scheduleCard.setUserId(userId);
            scheduleCard.setCardSn(cardSn);
            int id = scheduleCardDao.insertReturnId(scheduleCard);
            scheduleCard.setId(id);
        } else {
            scheduleCard = scheduleCards.get(0);
        }
        SmsScheduleBaseRowExample queryList = new SmsScheduleBaseRowExample();
        queryList.createCriteria().andCardIdEqualTo(scheduleCard.getId());
        // 2. 查找日程卡对应记录
        List<SmsScheduleBaseRow> scheduleBaseRows = scheduleBaseRowMapper.selectByExample(queryList);
        ScheduleCardWithRow result = new ScheduleCardWithRow();
        BeanUtils.copyProperties(scheduleCard, result);
        // 3. 返回结果
        result.setRows(scheduleBaseRows);
        return result;
    }

    @Override
    public ScheduleCardWithGroupByRow getByGroup(int userId, String cardSn, String group) {
        ScheduleCardWithRow scheduleCardWithRow = get(userId, cardSn);
        List<SmsScheduleBaseRow> rows = scheduleCardWithRow.getRows();
        ScheduleCardWithGroupByRow rowGroupBy = new ScheduleCardWithGroupByRow();
        Function<SmsScheduleBaseRow, Integer> function = getGroupFieldFunction.get(group);
        if (ObjectUtil.isNotNull(function)) {
            Map<Integer, List<SmsScheduleBaseRow>> collect = rows.stream().collect(Collectors.groupingBy(function));
            rowGroupBy.setGroups(collect);
            rowGroupBy.setHasData(true);
        } else {
            rowGroupBy.setHasData(false);
        }
        return rowGroupBy;
    }
}
