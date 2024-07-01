package cn.yuanyuan.sp.foreground.controller;

import cn.yuanyuan.sp.api.service.ISmsFactorService;
import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.foreground.dto.FactorValueDTO;
import cn.yuanyuan.sp.foreground.service.SmsRowFactorValueService;
import cn.yuanyuan.sp.mbg.model.SmsFactor;
import cn.yuanyuan.sp.mbg.model.SmsScheduleRowFactorValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/schedule-rector")
@Api("日程因素控制器")
public class SmsScheduleRectorController {

    @DubboReference(version = "${sp.service.version}")
    private ISmsFactorService smsFactorService;

    @Resource
    SmsRowFactorValueService rowFactorValueService;

    @ApiOperation("根据因素列别获取元属性")
    @GetMapping("/meta")
    public CommonResult<List<SmsFactor>> getFactorMeta(@RequestParam("factorCategoryId") int factorCategoryId) {
        return CommonResult.success(smsFactorService.getFactorMeta(factorCategoryId));
    }

    @ApiOperation("row添加元素")
    @PostMapping("/push-factor")
    public CommonResult<Integer> pushFactor(@RequestBody FactorValueDTO factorValue) {
        Integer count = rowFactorValueService.insertFactorValue(factorValue);
        return CommonResult.success(count);
    }

    @ApiOperation("row更新元素")
    @PutMapping("/push-factor")
    public CommonResult<Integer> putFactor(@RequestBody FactorValueDTO factorValue) {
        Integer count = rowFactorValueService.updateFactorValue(factorValue);
        return CommonResult.success(count);
    }

    @ApiOperation("查看row元素信息")
    @GetMapping("/factor-value")
    public CommonResult<SmsScheduleRowFactorValue> getFactorValue(@RequestParam("rowId")int rowId) {
        return CommonResult.success(rowFactorValueService.getFactorValue(rowId));
    }
}
