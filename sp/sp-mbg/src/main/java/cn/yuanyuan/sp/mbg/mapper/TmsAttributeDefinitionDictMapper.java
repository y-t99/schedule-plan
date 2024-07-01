package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.TmsAttributeDefinitionDict;
import cn.yuanyuan.sp.mbg.model.TmsAttributeDefinitionDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmsAttributeDefinitionDictMapper {
    long countByExample(TmsAttributeDefinitionDictExample example);

    int deleteByExample(TmsAttributeDefinitionDictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmsAttributeDefinitionDict record);

    int insertSelective(TmsAttributeDefinitionDict record);

    List<TmsAttributeDefinitionDict> selectByExample(TmsAttributeDefinitionDictExample example);

    TmsAttributeDefinitionDict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmsAttributeDefinitionDict record, @Param("example") TmsAttributeDefinitionDictExample example);

    int updateByExample(@Param("record") TmsAttributeDefinitionDict record, @Param("example") TmsAttributeDefinitionDictExample example);

    int updateByPrimaryKeySelective(TmsAttributeDefinitionDict record);

    int updateByPrimaryKey(TmsAttributeDefinitionDict record);
}