package cn.yuanyuan.sp.foreground.service;


import cn.yuanyuan.sp.foreground.dto.ScheduleCardWithGroupByRow;
import cn.yuanyuan.sp.foreground.dto.ScheduleCardWithRow;
import cn.yuanyuan.sp.mbg.model.SmsScheduleCard;

public interface SmsScheduleCardService {

    /**
     * 根据用户userId和cardSn获取日程卡信息
     * @param userId 用户id
     * @param cardId 日程卡cardSn
     * @return 日程卡信息
     */
    ScheduleCardWithRow get(int userId, String cardId);

    /**
     *
     * @param userId 用户id
     * @param cardSn 日程卡cardSn
     * @param group 分组条件
     * @return 分组记录信息
     */
    ScheduleCardWithGroupByRow getByGroup(int userId, String cardSn, String group);
}
