package cn.yuanyuan.sp.foreground.service.impl;

import cn.yuanyuan.sp.foreground.service.SmsScheduleDataViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static cn.yuanyuan.sp.foreground.constant.ScheduleEnableGroupField.*;
import static cn.yuanyuan.sp.foreground.constant.ScheduleEnableGroupField.ScheduleFactorCategoryId;

@Service
public class SmsScheduleDataViewServiceImpl implements SmsScheduleDataViewService {

    @Override
    public List<String> getEnableGroupFields() {
        List<String> enableGroupFields = new ArrayList<>();
        enableGroupFields.add(Priority.getField());
        enableGroupFields.add(ScheduleFactorCategoryId.getField());
        enableGroupFields.add(IsDelay.getField());
        enableGroupFields.add(IsFinish.getField());
        return enableGroupFields;
    }
}
