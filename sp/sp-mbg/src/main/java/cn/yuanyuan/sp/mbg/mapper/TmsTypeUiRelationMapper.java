package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.TmsTypeUiRelation;
import cn.yuanyuan.sp.mbg.model.TmsTypeUiRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmsTypeUiRelationMapper {
    long countByExample(TmsTypeUiRelationExample example);

    int deleteByExample(TmsTypeUiRelationExample example);

    int deleteByPrimaryKey(@Param("typeId") Integer typeId, @Param("isInput") Byte isInput, @Param("uiId") Integer uiId);

    int insert(TmsTypeUiRelation record);

    int insertSelective(TmsTypeUiRelation record);

    List<TmsTypeUiRelation> selectByExample(TmsTypeUiRelationExample example);

    int updateByExampleSelective(@Param("record") TmsTypeUiRelation record, @Param("example") TmsTypeUiRelationExample example);

    int updateByExample(@Param("record") TmsTypeUiRelation record, @Param("example") TmsTypeUiRelationExample example);
}