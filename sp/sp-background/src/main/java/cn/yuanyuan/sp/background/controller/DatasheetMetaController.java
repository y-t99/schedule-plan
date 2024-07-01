package cn.yuanyuan.sp.background.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.yuanyuan.sp.background.dto.DatasheetMeta;
import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.mbg.mapper.TmsAttributeDefinitionDictMapper;
import cn.yuanyuan.sp.mbg.mapper.TmsAttributeMapper;
import cn.yuanyuan.sp.mbg.model.TmsAttribute;
import cn.yuanyuan.sp.mbg.model.TmsAttributeDefinitionDictExample;
import cn.yuanyuan.sp.mbg.model.TmsAttributeExample;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/datasheet-meta")
@Api(tags = "模板定义控制器")
public class DatasheetMetaController {

    @Resource
    TmsAttributeMapper attributeMapper;

    @Resource
    TmsAttributeDefinitionDictMapper attributeDefinitionDictMapper;

    @GetMapping("/all")
    public CommonResult<List<DatasheetMeta>> allMeta() {
        TmsAttributeExample condition = new TmsAttributeExample();
        List<TmsAttribute> tmsAttributes = attributeMapper.selectByExample(condition);
        List<DatasheetMeta> metas = new ArrayList<>();
        for (TmsAttribute attributeMeta : tmsAttributes) {
            DatasheetMeta datasheetMeta = new DatasheetMeta();
            BeanUtil.copyProperties(attributeMeta, datasheetMeta);
            TmsAttributeDefinitionDictExample children = new TmsAttributeDefinitionDictExample();
            children.createCriteria().andAttributetIdEqualTo(datasheetMeta.getId());
            datasheetMeta.setChildrens(attributeDefinitionDictMapper.selectByExample(children));
            metas.add(datasheetMeta);
        }
        return CommonResult.success(metas);
    }
}
