package cn.yuanyuan.sp.foreground.dao;

import cn.yuanyuan.sp.mbg.model.SmsScheduleCard;

public interface SmsScheduleCardDao {

    /**
     * 插入日程卡并返回其在数据库的id
     * @param record 日程卡信息
     * @return 日程卡id
     */
    int insertReturnId(SmsScheduleCard record);
}
