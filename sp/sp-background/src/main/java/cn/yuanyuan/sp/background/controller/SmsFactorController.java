package cn.yuanyuan.sp.background.controller;

import cn.yuanyuan.sp.background.dto.FactorParameter;
import cn.yuanyuan.sp.background.dto.FactorUpdateParameter;
import cn.yuanyuan.sp.background.dto.FactorWithCategory;
import cn.yuanyuan.sp.background.service.SmsFactorService;
import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.common.exception.InsertForbidException;
import cn.yuanyuan.sp.common.exception.UpdateForbidException;
import cn.yuanyuan.sp.mbg.model.SmsFactor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "因素库控制器")
@RestController
@RequestMapping("/factor")
public class SmsFactorController {

    final SmsFactorService factorService;

    public SmsFactorController(SmsFactorService factorService) {
        this.factorService = factorService;
    }

    @ApiOperation("根据分类id查找因素")
    @GetMapping("/list/category-id/{category_id}")
    public CommonResult<List<FactorWithCategory>> queryByCategoryId(@PathVariable("category_id") Integer categoryId) {
        List<FactorWithCategory> factors = factorService.queryByCategoryId(categoryId);
        return CommonResult.success(factors);
    }

    @ApiOperation("根据分类名称查找因素")
    @GetMapping("/list/category-name/{category_name}")
    public CommonResult<List<FactorWithCategory>> queryByCategoryName(@PathVariable("category_name") String categoryName) {
        List<FactorWithCategory> factors = factorService.queryByCategoryName(categoryName);
        return CommonResult.success(factors);
    }

    @ApiOperation("根据因素id查找因素详细信息")
    @GetMapping("/{id}")
    public CommonResult<FactorWithCategory> queryById(@PathVariable("id") Integer id) {
        FactorWithCategory factor = factorService.queryById(id);
        return CommonResult.success(factor);
    }

    @ApiOperation("查找所有因素详细信息")
    @GetMapping("/all")
    public CommonResult<List<FactorWithCategory>> queryAll() {
        List<FactorWithCategory> factors = factorService.queryAll();
        return CommonResult.success(factors);
    }

    @ApiOperation("根据因素名称查找因素详细信息")
    @GetMapping("/name/{name}")
    public CommonResult<List<FactorWithCategory>> queryById(@PathVariable("name") String name) {
        List<FactorWithCategory> factor = factorService.queryByName(name);
        return CommonResult.success(factor);
    }

    @ApiOperation("根据因素id删除因素")
    @DeleteMapping("/{id}")
    public CommonResult<Integer> deleteById(@PathVariable("id") Integer id) {
        int count = factorService.deleteById(id);
        return CommonResult.success(count);
    }

    @ApiOperation("创建因素")
    @PostMapping("/create")
    public CommonResult<Integer> create(@Validated @RequestBody FactorParameter parameter) {
        int count;
        try {
            count = factorService.create(parameter);
        } catch (InsertForbidException e) {
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(count);
    }

    @ApiOperation("更改因素信息")
    @PutMapping("/{id}")
    public CommonResult<Integer> update(
            @PathVariable("id") Integer id,
            @Validated @RequestBody FactorUpdateParameter parameter) {
        int count;
        try {
            count = factorService.updateById(id, parameter);
        } catch (UpdateForbidException e) {
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(count);
    }
}
