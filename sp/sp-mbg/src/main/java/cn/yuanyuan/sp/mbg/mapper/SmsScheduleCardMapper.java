package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.SmsScheduleCard;
import cn.yuanyuan.sp.mbg.model.SmsScheduleCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsScheduleCardMapper {
    long countByExample(SmsScheduleCardExample example);

    int deleteByExample(SmsScheduleCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsScheduleCard record);

    int insertSelective(SmsScheduleCard record);

    List<SmsScheduleCard> selectByExample(SmsScheduleCardExample example);

    SmsScheduleCard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmsScheduleCard record, @Param("example") SmsScheduleCardExample example);

    int updateByExample(@Param("record") SmsScheduleCard record, @Param("example") SmsScheduleCardExample example);

    int updateByPrimaryKeySelective(SmsScheduleCard record);

    int updateByPrimaryKey(SmsScheduleCard record);
}