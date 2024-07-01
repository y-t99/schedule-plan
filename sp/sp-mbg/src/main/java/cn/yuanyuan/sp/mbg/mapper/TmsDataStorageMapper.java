package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.TmsDataStorage;
import cn.yuanyuan.sp.mbg.model.TmsDataStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmsDataStorageMapper {
    long countByExample(TmsDataStorageExample example);

    int deleteByExample(TmsDataStorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmsDataStorage record);

    int insertSelective(TmsDataStorage record);

    List<TmsDataStorage> selectByExample(TmsDataStorageExample example);

    TmsDataStorage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmsDataStorage record, @Param("example") TmsDataStorageExample example);

    int updateByExample(@Param("record") TmsDataStorage record, @Param("example") TmsDataStorageExample example);

    int updateByPrimaryKeySelective(TmsDataStorage record);

    int updateByPrimaryKey(TmsDataStorage record);
}