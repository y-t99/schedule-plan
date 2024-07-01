package cn.yuanyuan.sp.foreground.service;

import cn.yuanyuan.sp.foreground.dto.ScheduleRowMeta;
import cn.yuanyuan.sp.foreground.dto.ScheduleRowParameter;
import cn.yuanyuan.sp.mbg.model.SmsScheduleBaseRow;

import java.util.List;

public interface SmsScheduleBaseService{

    /**
     * 添加日程需要的元属性信息
     * @return 各因素类别、因素属性信息
     */
    ScheduleRowMeta getScheduleRowMeta();

    /**
     * 创建日程记录
     * @param parameter 日程记录信息
     * @return 影响行数
     */
    int create(ScheduleRowParameter parameter);

    /**
     * 根据日程卡id查询日程卡记录
     * @param cardId 日程id
     * @return 日程卡记录
     */
    List<SmsScheduleBaseRow> getScheduleRowsByCardId(Integer cardId);

    int updateRow(SmsScheduleBaseRow row);

    int toggleFinishStatue(Integer rowId, Integer statue);

    int toggleDelayStatue(Integer rowId, Integer statue);
}
