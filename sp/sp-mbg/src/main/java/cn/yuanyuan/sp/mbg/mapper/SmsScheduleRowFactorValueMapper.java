package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.SmsScheduleRowFactorValue;
import cn.yuanyuan.sp.mbg.model.SmsScheduleRowFactorValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsScheduleRowFactorValueMapper {
    long countByExample(SmsScheduleRowFactorValueExample example);

    int deleteByExample(SmsScheduleRowFactorValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsScheduleRowFactorValue record);

    int insertSelective(SmsScheduleRowFactorValue record);

    List<SmsScheduleRowFactorValue> selectByExample(SmsScheduleRowFactorValueExample example);

    SmsScheduleRowFactorValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmsScheduleRowFactorValue record, @Param("example") SmsScheduleRowFactorValueExample example);

    int updateByExample(@Param("record") SmsScheduleRowFactorValue record, @Param("example") SmsScheduleRowFactorValueExample example);

    int updateByPrimaryKeySelective(SmsScheduleRowFactorValue record);

    int updateByPrimaryKey(SmsScheduleRowFactorValue record);
}