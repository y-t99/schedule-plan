package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.TmsStructureDefinition;
import cn.yuanyuan.sp.mbg.model.TmsStructureDefinitionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmsStructureDefinitionMapper {
    long countByExample(TmsStructureDefinitionExample example);

    int deleteByExample(TmsStructureDefinitionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmsStructureDefinition record);

    int insertSelective(TmsStructureDefinition record);

    List<TmsStructureDefinition> selectByExample(TmsStructureDefinitionExample example);

    TmsStructureDefinition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmsStructureDefinition record, @Param("example") TmsStructureDefinitionExample example);

    int updateByExample(@Param("record") TmsStructureDefinition record, @Param("example") TmsStructureDefinitionExample example);

    int updateByPrimaryKeySelective(TmsStructureDefinition record);

    int updateByPrimaryKey(TmsStructureDefinition record);
}