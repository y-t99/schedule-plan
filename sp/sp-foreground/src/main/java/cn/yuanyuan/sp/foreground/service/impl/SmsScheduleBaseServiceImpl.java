package cn.yuanyuan.sp.foreground.service.impl;

import cn.yuanyuan.sp.api.dto.FactorCategoryWithFactors;
import cn.yuanyuan.sp.api.service.ISmsFactorCategoryService;
import cn.yuanyuan.sp.api.service.ISmsFactorService;
import cn.yuanyuan.sp.foreground.dto.ScheduleRowMeta;
import cn.yuanyuan.sp.foreground.dto.ScheduleRowParameter;
import cn.yuanyuan.sp.foreground.service.SmsScheduleBaseService;
import cn.yuanyuan.sp.mbg.mapper.SmsScheduleBaseRowMapper;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategory;
import cn.yuanyuan.sp.mbg.model.SmsScheduleBaseRow;
import cn.yuanyuan.sp.mbg.model.SmsScheduleBaseRowExample;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmsScheduleBaseServiceImpl implements SmsScheduleBaseService {

    @DubboReference(version = "${sp.service.version}")
    private ISmsFactorService factorService;
    @DubboReference(version = "${sp.service.version}")
    private ISmsFactorCategoryService factorCategoryService;

    @Resource
    SmsScheduleBaseRowMapper scheduleBaseRowMapper;

    @Override
    public ScheduleRowMeta getScheduleRowMeta() {
        List<SmsFactorCategory> smsFactorCategories = factorCategoryService.queryAll();
        List<FactorCategoryWithFactors> factorCategoryWithFactors = factorCategoryService.queryAllWithFactors();
        ScheduleRowMeta meta = new ScheduleRowMeta();
        meta.setSmsFactorCategories(smsFactorCategories);
        meta.setFactorCategoryWithFactors(factorCategoryWithFactors);
        return meta;
    }

    @Override
    public int create(ScheduleRowParameter parameter) {
        SmsScheduleBaseRow smsScheduleBaseRow = new SmsScheduleBaseRow();
        BeanUtils.copyProperties(parameter, smsScheduleBaseRow);
        smsScheduleBaseRow.setIsDelay(0);
        smsScheduleBaseRow.setIsFinish(0);
        return scheduleBaseRowMapper.insertSelective(smsScheduleBaseRow);
    }

    @Override
    public List<SmsScheduleBaseRow> getScheduleRowsByCardId(Integer cardId) {
        SmsScheduleBaseRowExample condition = new SmsScheduleBaseRowExample();
        condition.createCriteria().andCardIdEqualTo(cardId);
        return scheduleBaseRowMapper.selectByExample(condition);
    }

    @Override
    public int updateRow(SmsScheduleBaseRow row) {
        return scheduleBaseRowMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int toggleFinishStatue(Integer rowId, Integer statue) {
        SmsScheduleBaseRow row = new SmsScheduleBaseRow();
        row.setId(rowId);
        row.setIsFinish(statue);
        return scheduleBaseRowMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int toggleDelayStatue(Integer rowId, Integer statue) {
        SmsScheduleBaseRow row = new SmsScheduleBaseRow();
        row.setId(rowId);
        row.setIsDelay(statue);
        return scheduleBaseRowMapper.updateByPrimaryKeySelective(row);
    }


}
