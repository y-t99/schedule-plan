package cn.yuanyuan.sp.foreground.controller;

import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.foreground.dto.ScheduleCardWithRow;
import cn.yuanyuan.sp.foreground.service.SmsScheduleCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "日程计划卡控制器")
@RequestMapping("/schedule-card")
public class SmsScheduleCardController {

    final SmsScheduleCardService scheduleCardService;

    public SmsScheduleCardController(SmsScheduleCardService scheduleCardService) {
        this.scheduleCardService = scheduleCardService;
    }

    @ApiOperation("用户获取带记录的日程卡")
    @GetMapping("/getCard")
    public CommonResult<ScheduleCardWithRow> get(@RequestParam("userId") int userId, @RequestParam("cardSn") String cardSn) {
        ScheduleCardWithRow card = scheduleCardService.get(userId, cardSn);
        return CommonResult.success(card);
    }
}
