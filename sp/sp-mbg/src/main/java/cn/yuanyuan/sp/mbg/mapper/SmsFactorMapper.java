package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.SmsFactor;
import cn.yuanyuan.sp.mbg.model.SmsFactorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsFactorMapper {
    long countByExample(SmsFactorExample example);

    int deleteByExample(SmsFactorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsFactor record);

    int insertSelective(SmsFactor record);

    List<SmsFactor> selectByExample(SmsFactorExample example);

    SmsFactor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmsFactor record, @Param("example") SmsFactorExample example);

    int updateByExample(@Param("record") SmsFactor record, @Param("example") SmsFactorExample example);

    int updateByPrimaryKeySelective(SmsFactor record);

    int updateByPrimaryKey(SmsFactor record);
}