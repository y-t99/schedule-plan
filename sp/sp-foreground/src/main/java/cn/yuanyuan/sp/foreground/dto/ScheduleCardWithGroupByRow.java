package cn.yuanyuan.sp.foreground.dto;

import cn.yuanyuan.sp.mbg.model.SmsScheduleBaseRow;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;
import java.util.Map;

@ApiModel("带分组记录的日程卡")
@Data
public class ScheduleCardWithGroupByRow{

    private Boolean hasData;

    private Map<Integer, List<SmsScheduleBaseRow>> groups;
}
