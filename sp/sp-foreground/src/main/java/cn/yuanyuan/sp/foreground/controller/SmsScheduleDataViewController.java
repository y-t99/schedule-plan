package cn.yuanyuan.sp.foreground.controller;

import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.foreground.constant.ScheduleEnableGroupField;
import cn.yuanyuan.sp.foreground.dto.ScheduleCardWithGroupByRow;
import cn.yuanyuan.sp.foreground.dto.ScheduleCardWithRow;
import cn.yuanyuan.sp.foreground.service.SmsScheduleCardService;
import cn.yuanyuan.sp.foreground.service.SmsScheduleDataViewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static cn.yuanyuan.sp.foreground.constant.ScheduleEnableGroupField.*;

@RestController
@Api(tags = "日程数据视图控制器")
@RequestMapping("/schedule-data-view")
public class SmsScheduleDataViewController {

    @Resource
    SmsScheduleCardService scheduleCardService;
    @Resource
    SmsScheduleDataViewService scheduleDataViewService;

    @ApiOperation("日程记录可分组的字段属性")
    @GetMapping("/enable-group-field")
    public CommonResult<List<String>> enableGroupField() {
        List<String> enableGroupFields = scheduleDataViewService.getEnableGroupFields();
        return CommonResult.success(enableGroupFields);
    }

    @ApiOperation("根据类别获取带记录的日程卡")
    @GetMapping("/getRowsByGroup")
    public CommonResult<ScheduleCardWithGroupByRow> get(@RequestParam("userId") int userId,
                                                        @RequestParam("cardSn") String cardSn,
                                                        @RequestParam("group") String group) {
        ScheduleCardWithGroupByRow cardWithGroupByRow = scheduleCardService.getByGroup(userId, cardSn, group);
        return CommonResult.success(cardWithGroupByRow);
    }

}
