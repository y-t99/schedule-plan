package cn.yuanyuan.sp.foreground.service.impl;

import cn.yuanyuan.sp.foreground.dto.DataStorageDTO;
import cn.yuanyuan.sp.foreground.dto.DatasheetStructureDTO;
import cn.yuanyuan.sp.foreground.service.DatasheetService;
import cn.yuanyuan.sp.mbg.mapper.TmsDataStorageMapper;
import cn.yuanyuan.sp.mbg.mapper.TmsStructureDefinitionMapper;
import cn.yuanyuan.sp.mbg.model.TmsDataStorage;
import cn.yuanyuan.sp.mbg.model.TmsDataStorageExample;
import cn.yuanyuan.sp.mbg.model.TmsStructureDefinition;
import cn.yuanyuan.sp.mbg.model.TmsStructureDefinitionExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DatasheetServiceImpl implements DatasheetService {

    @Resource
    TmsStructureDefinitionMapper structureDefinitionMapper;

    @Resource
    TmsDataStorageMapper dataStorageMapper;

    @Override
    public Integer addDatasheet(DatasheetStructureDTO structureDTO) {
        TmsStructureDefinition structureDefinition = new TmsStructureDefinition();
        BeanUtils.copyProperties(structureDTO, structureDefinition);
        return structureDefinitionMapper.insert(structureDefinition);
    }

    @Override
    public List<TmsStructureDefinition> queryAllDatasheetMeta(int userId) {
        TmsStructureDefinitionExample condition = new TmsStructureDefinitionExample();
        condition.createCriteria().andUserIdEqualTo(userId);
        return structureDefinitionMapper.selectByExample(condition);
    }

    @Override
    public Integer addDataStorage(DataStorageDTO dataStorageDTO) {
        TmsDataStorage insertData = new TmsDataStorage();
        BeanUtils.copyProperties(dataStorageDTO, insertData);
        return dataStorageMapper.insert(insertData);
    }

    @Override
    public List<TmsDataStorage> queryAllDataStorageByDstId(Integer dstId) {
        TmsDataStorageExample condition = new TmsDataStorageExample();
        condition.createCriteria().andTableStructureIdEqualTo(dstId);
        return dataStorageMapper.selectByExample(condition);
    }
}
