package cn.yuanyuan.sp.foreground.controller;

import cn.hutool.core.collection.CollUtil;
import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.foreground.dto.ScheduleHistory;
import cn.yuanyuan.sp.mbg.mapper.SmsScheduleBaseRowMapper;
import cn.yuanyuan.sp.mbg.mapper.SmsScheduleCardMapper;
import cn.yuanyuan.sp.mbg.mapper.SmsScheduleRowFactorValueMapper;
import cn.yuanyuan.sp.mbg.mapper.UmsUserMapper;
import cn.yuanyuan.sp.mbg.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    UmsUserMapper userMapper;

    @Autowired
    SmsScheduleCardMapper cardMapper;

    @Autowired
    SmsScheduleBaseRowMapper rowMapper;

    @Autowired
    SmsScheduleRowFactorValueMapper rowFactorValueMapper;

    @GetMapping("/{userId}")
    public CommonResult<ScheduleHistory> history(@PathVariable("userId") int userId) {
        // 1. 取出所有的日程卡
        SmsScheduleCardExample cardCondition = new SmsScheduleCardExample();
        cardCondition.createCriteria().andUserIdEqualTo(userId);
        List<SmsScheduleCard> cards = cardMapper.selectByExample(cardCondition);
        // 2. 取出所有的日程记录
        List<Integer> cardIds = cards.stream().map(SmsScheduleCard::getId).collect(Collectors.toList());
        SmsScheduleBaseRowExample rowCondition = new SmsScheduleBaseRowExample();
        rowCondition.createCriteria().andCardIdIn(cardIds);
        List<SmsScheduleBaseRow> rows = rowMapper.selectByExample(rowCondition);
        // 3. 封装返回结果
        ScheduleHistory history = new ScheduleHistory();
        // 总计记录行
        history.setCount(rows.size());
        // 前三情绪
        List<String> pnsns = cards.stream().map(SmsScheduleCard::getPnsns)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        Map<String, Long> pnsnsCount = pnsns.stream()
                .map(pnsn -> pnsn.split(","))
                .flatMap(Stream::of)
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        List<Map.Entry<String, Long>> sordedPnsns = pnsnsCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        if (sordedPnsns.size() > 3) {
            sordedPnsns = sordedPnsns.subList(0, 3);
        }
        List<String> top3 = new ArrayList<>();
        sordedPnsns.forEach(e -> top3.add(e.getKey()));
        Collections.reverse(top3);
        String[] top3Result = new String[top3.size()];
        for (int i = 0; i < top3Result.length; i++) {
            top3Result[i] = top3.get(i);
        }
        history.setTop3PNANS(top3Result);
        // 标签统计
        // 获取用户所有因素行，并按因素分类。
        List<Integer> rowIds = rows.stream().map(SmsScheduleBaseRow::getId).collect(Collectors.toList());
        SmsScheduleRowFactorValueExample rowFactorValuecondition = new SmsScheduleRowFactorValueExample();
        rowFactorValuecondition.createCriteria().andRowIdIn(rowIds);
        List<SmsScheduleRowFactorValue> factorValues = rowFactorValueMapper.selectByExample(rowFactorValuecondition);
        Map<Integer, List<SmsScheduleRowFactorValue>> map = factorValues.stream().filter(i -> i.getFactorId() == 21)
                .collect(Collectors.groupingBy(SmsScheduleRowFactorValue::getFactorId));
        // 吃饭便签
        List<SmsScheduleRowFactorValue> eatingList = map.get(21);
        if (CollUtil.isNotEmpty(eatingList)) {
            String food = extracted(eatingList);
            history.setFood(food);
        }
        // 专业阅读
        List<SmsScheduleRowFactorValue> professionalList = map.get(5);
        if (CollUtil.isNotEmpty(professionalList)) {
            String professionalBook = extracted(professionalList);
            history.setProfessionalBook(professionalBook);
        }
        // 课外阅读
        List<SmsScheduleRowFactorValue> classicsList = map.get(18);
        if (CollUtil.isNotEmpty(classicsList)) {
            String interestedBook = extracted(classicsList);
            history.setInterestedBook(interestedBook);
        }
        // 手机刷屏
        List<SmsScheduleRowFactorValue> iphoneList = map.get(9);
        if (CollUtil.isNotEmpty(iphoneList)) {
            String iphone = extracted(iphoneList);
            history.setApp(iphone);
        }
        // 游戏
        List<SmsScheduleRowFactorValue> gameList = map.get(10);
        if (CollUtil.isNotEmpty(gameList)) {
            String game = extracted(gameList);
            history.setGame(game);
        }
        // 起床
        List<SmsScheduleRowFactorValue> getUp = map.get(1);
        if (CollUtil.isNotEmpty(getUp)) {
            Map<String, Long> getUpGroup = getUp.stream().map(SmsScheduleRowFactorValue::getFactorValues)
                    .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
            history.setGetUpCount(getUpGroup);
        }
        // 睡觉
        List<SmsScheduleRowFactorValue> getToBed = map.get(2);
        if (CollUtil.isNotEmpty(getToBed)) {
            Map<String, Long> getToBedGroup = getToBed.stream().map(SmsScheduleRowFactorValue::getFactorValues)
                    .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
            history.setGetToBedCount(getToBedGroup);
        }
        // 类别
        Map<String, Long> categoryGroup = rows.stream().map(SmsScheduleBaseRow::getScheduleFactorCategoryName)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        history.setCategoryCount(categoryGroup);
        return CommonResult.success(history);
    }

    private String extracted(List<SmsScheduleRowFactorValue> list) {
        List<String> tags = list.stream()
                .map(i -> i.getFactorValues().split(","))
                .flatMap(Stream::of)
                .collect(Collectors.toList());
        Map<String, Long> group = tags.stream().map(String::trim)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        List<Map.Entry<String, Long>> sortedGroup = group.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        Collections.reverse(sortedGroup);
        return sortedGroup.get(0).getKey();
    }

}
