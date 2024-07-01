package cn.yuanyuan.sp.foreground.dto;

import cn.yuanyuan.sp.mbg.model.SmsScheduleBaseRow;
import cn.yuanyuan.sp.mbg.model.SmsScheduleCard;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@ApiModel("带记录的日程卡")
public class ScheduleCardWithRow extends SmsScheduleCard {

    @Getter
    @Setter
    private List<SmsScheduleBaseRow> rows;
}
