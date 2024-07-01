package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.SmsScheduleBaseRow;
import cn.yuanyuan.sp.mbg.model.SmsScheduleBaseRowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsScheduleBaseRowMapper {
    long countByExample(SmsScheduleBaseRowExample example);

    int deleteByExample(SmsScheduleBaseRowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsScheduleBaseRow record);

    int insertSelective(SmsScheduleBaseRow record);

    List<SmsScheduleBaseRow> selectByExample(SmsScheduleBaseRowExample example);

    SmsScheduleBaseRow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmsScheduleBaseRow record, @Param("example") SmsScheduleBaseRowExample example);

    int updateByExample(@Param("record") SmsScheduleBaseRow record, @Param("example") SmsScheduleBaseRowExample example);

    int updateByPrimaryKeySelective(SmsScheduleBaseRow record);

    int updateByPrimaryKey(SmsScheduleBaseRow record);
}