package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.TmsAttribute;
import cn.yuanyuan.sp.mbg.model.TmsAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmsAttributeMapper {
    long countByExample(TmsAttributeExample example);

    int deleteByExample(TmsAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmsAttribute record);

    int insertSelective(TmsAttribute record);

    List<TmsAttribute> selectByExample(TmsAttributeExample example);

    TmsAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmsAttribute record, @Param("example") TmsAttributeExample example);

    int updateByExample(@Param("record") TmsAttribute record, @Param("example") TmsAttributeExample example);

    int updateByPrimaryKeySelective(TmsAttribute record);

    int updateByPrimaryKey(TmsAttribute record);
}