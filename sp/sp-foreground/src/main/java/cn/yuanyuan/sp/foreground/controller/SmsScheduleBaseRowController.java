package cn.yuanyuan.sp.foreground.controller;

import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.foreground.dto.ScheduleCardWithRow;
import cn.yuanyuan.sp.foreground.dto.ScheduleRowMeta;
import cn.yuanyuan.sp.foreground.dto.ScheduleRowParameter;
import cn.yuanyuan.sp.foreground.dto.StatueDTO;
import cn.yuanyuan.sp.foreground.service.SmsScheduleBaseService;
import cn.yuanyuan.sp.mbg.model.SmsScheduleBaseRow;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule-base-row")
@Api(tags = "日程行控制器")
public class SmsScheduleBaseRowController {

    final SmsScheduleBaseService scheduleBaseService;

    public SmsScheduleBaseRowController(SmsScheduleBaseService scheduleBaseService) {
        this.scheduleBaseService = scheduleBaseService;
    }

    @ApiOperation("获取用户填写日程卡需要的日程信息")
    @GetMapping("/schedule-row-meta")
    public CommonResult<ScheduleRowMeta> getScheduleRowMeta() {
        ScheduleRowMeta meta = scheduleBaseService.getScheduleRowMeta();
        return CommonResult.success(meta);
    }

    @ApiOperation("创建日程")
    @PostMapping("/create")
    public CommonResult<List<SmsScheduleBaseRow>> create(@Validated @RequestBody ScheduleRowParameter parameter) {
        int count = scheduleBaseService.create(parameter);
        if (count == 1) {
            List<SmsScheduleBaseRow> rows = scheduleBaseService.getScheduleRowsByCardId(parameter.getCardId());
            return CommonResult.success(rows);
        }
        return CommonResult.failed("插入失败");
    }

    @ApiOperation("更新日程日程")
    @PutMapping("/push-row")
    public CommonResult<Integer> putRow(@Validated @RequestBody SmsScheduleBaseRow row) {
        int count = scheduleBaseService.updateRow(row);
        return CommonResult.success(count);
    }

    @ApiOperation("更新完成情况")
    @PutMapping("/toggle-finish-statue")
    public CommonResult<Integer> putFinishStatue(@RequestBody StatueDTO statue) {
        int count = scheduleBaseService.toggleFinishStatue(statue.getRowId(), statue.getStatue());
        return CommonResult.success(count);
    }

    @ApiOperation("更新完成情况")
    @PutMapping("/toggle-delay-statue")
    public CommonResult<Integer> putDelayStatue(@RequestBody StatueDTO statue) {
        int count = scheduleBaseService.toggleDelayStatue(statue.getRowId(), statue.getStatue());
        return CommonResult.success(count);
    }
}