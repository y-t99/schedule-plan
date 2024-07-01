package cn.yuanyuan.sp.foreground.service;

import cn.yuanyuan.sp.foreground.dto.FactorValueDTO;
import cn.yuanyuan.sp.mbg.model.SmsScheduleRowFactorValue;

public interface SmsRowFactorValueService {

    Integer insertFactorValue(FactorValueDTO factorValue);

    SmsScheduleRowFactorValue getFactorValue(int rowId);

    Integer updateFactorValue(FactorValueDTO factorValue);
}
