package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.SmsFactorCategory;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsFactorCategoryMapper {
    long countByExample(SmsFactorCategoryExample example);

    int deleteByExample(SmsFactorCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsFactorCategory record);

    int insertSelective(SmsFactorCategory record);

    List<SmsFactorCategory> selectByExample(SmsFactorCategoryExample example);

    SmsFactorCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmsFactorCategory record, @Param("example") SmsFactorCategoryExample example);

    int updateByExample(@Param("record") SmsFactorCategory record, @Param("example") SmsFactorCategoryExample example);

    int updateByPrimaryKeySelective(SmsFactorCategory record);

    int updateByPrimaryKey(SmsFactorCategory record);
}