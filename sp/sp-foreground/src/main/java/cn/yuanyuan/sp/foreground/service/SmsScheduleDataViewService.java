package cn.yuanyuan.sp.foreground.service;

import java.util.List;

public interface SmsScheduleDataViewService {

    /**
     * 日程记录可分组的字段属性
     * @return 可分组的字段属性
     */
    List<String> getEnableGroupFields();

}
