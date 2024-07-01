package cn.yuanyuan.sp.background.controller;

import cn.yuanyuan.sp.background.dto.FactorCategoryParameter;
import cn.yuanyuan.sp.background.dto.FactorCategoryWithFactors;
import cn.yuanyuan.sp.background.service.SmsFactorCategoryService;
import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.common.exception.DeleteForbidException;
import cn.yuanyuan.sp.common.exception.InsertForbidException;
import cn.yuanyuan.sp.common.exception.UpdateForbidException;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@Api(tags = "因素分类库控制器")
@RequestMapping("/factor-category")
public class SmsFactorCategoryController {

    final SmsFactorCategoryService factorCategoryService;

    public SmsFactorCategoryController(SmsFactorCategoryService factorCategoryService) {
        this.factorCategoryService = factorCategoryService;
    }

    @ApiOperation("获取全部的因素分类信息")
    @GetMapping("/queryAll")
    public CommonResult< List<SmsFactorCategory>> queryAll() {
        List<SmsFactorCategory> list = factorCategoryService.queryAll();
        return CommonResult.success(list);
    }

    @ApiOperation("获取全部的因素分类及其因素信息")
    @GetMapping("/queryAllWithFactors")
    public CommonResult<List<FactorCategoryWithFactors>> queryAllWithFactors() {
        List<FactorCategoryWithFactors> categoryWithFactors =
                                            factorCategoryService.queryAllWithFactors();
        return CommonResult.success(categoryWithFactors);
    }

    @ApiOperation("根据分类名称查找类别信息")
    @GetMapping("/{name}")
    public CommonResult<SmsFactorCategory> queryByName(@PathVariable@NotBlank String name) {
        SmsFactorCategory factorCategory = factorCategoryService.queryByName(name);
        return CommonResult.success(factorCategory);
    }

    @ApiOperation("删除因素分类")
    @DeleteMapping("/{id}")
    public CommonResult<Integer> deleteById(@PathVariable("id")int id) {
        int count;
        try {
            count = factorCategoryService.deleteById(id);
        } catch (DeleteForbidException e) {
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(count);
    }

    @ApiOperation("增加因素分类")
    @PostMapping("/create")
    public CommonResult<Integer> create(@Validated @RequestBody FactorCategoryParameter parameter) {
        int count;
        try {
            count = factorCategoryService.create(parameter);
        } catch (InsertForbidException e) {
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(count);
    }

    @ApiOperation("更改因素分类名称")
    @PutMapping("/updateName/{id}")
    public CommonResult<Integer> updateNameById(@PathVariable("id")@NotEmpty Integer id, @RequestParam("name")@NotBlank String name) {
        int count;
        try {
            count = factorCategoryService.updateNameById(id, name);
        } catch (UpdateForbidException e) {
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(count);
    }


}
