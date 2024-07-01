package cn.yuanyuan.sp.foreground.controller;


import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.common.domain.Tree;
import cn.yuanyuan.sp.foreground.dto.DataStorageDTO;
import cn.yuanyuan.sp.foreground.dto.DatasheetStructureDTO;
import cn.yuanyuan.sp.foreground.service.DatasheetService;
import cn.yuanyuan.sp.mbg.model.TmsDataStorage;
import cn.yuanyuan.sp.mbg.model.TmsStructureDefinition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "DataSheet控制器")
@RequestMapping("/datasheet")
public class TmsDataSheetController {

    @Resource
    DatasheetService datasheetService;

    @GetMapping("field-attribute")
    @ApiOperation("表字段的属性")
    public CommonResult<Tree> fieldAttribute() {

        return null;
    }

    @PostMapping("add-datasheet")
    @ApiOperation("添加数据表")
    public CommonResult<Integer> addDatasheet(@RequestBody DatasheetStructureDTO datasheetStructureDTO) {
        Integer integer = datasheetService.addDatasheet(datasheetStructureDTO);
        return CommonResult.success(integer);
    }

    @GetMapping("query-all-datasheet-meta")
    @ApiOperation("查看用户所有的数据表meta")
    public CommonResult<List<TmsStructureDefinition>> queryAllDatasheetMeta(@RequestParam("userId") Integer userId) {
        List<TmsStructureDefinition> structureDefinitions = datasheetService.queryAllDatasheetMeta(userId);
        return CommonResult.success(structureDefinitions);
    }

    @PostMapping("add-data-storage")
    @ApiOperation("添加数据行")
    public CommonResult<Integer> addDataStorage(@RequestBody DataStorageDTO dataStorageDTO) {
        Integer integer = datasheetService.addDataStorage(dataStorageDTO);
        return CommonResult.success(integer);
    }

    @GetMapping("query-data-storage")
    @ApiOperation("查询表数据")
    public CommonResult<List<TmsDataStorage>> addDataStorage(@RequestParam("dstId")Integer dstId) {
        List<TmsDataStorage> data = datasheetService.queryAllDataStorageByDstId(dstId);
        return CommonResult.success(data);
    }
}
