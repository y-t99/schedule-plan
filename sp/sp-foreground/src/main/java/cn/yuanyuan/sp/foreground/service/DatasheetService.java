package cn.yuanyuan.sp.foreground.service;

import cn.yuanyuan.sp.foreground.dto.DataStorageDTO;
import cn.yuanyuan.sp.foreground.dto.DatasheetStructureDTO;
import cn.yuanyuan.sp.mbg.model.TmsDataStorage;
import cn.yuanyuan.sp.mbg.model.TmsStructureDefinition;

import java.util.List;

public interface DatasheetService {

    Integer addDatasheet(DatasheetStructureDTO structDTO);

    List<TmsStructureDefinition> queryAllDatasheetMeta(int userId);

    Integer addDataStorage(DataStorageDTO dataStorageDTO);

    List<TmsDataStorage> queryAllDataStorageByDstId(Integer dstId);
}
