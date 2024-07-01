package cn.yuanyuan.sp.foreground.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("日程卡查询")
@Data
public class ScheduleCardQueryParameter {

    @ApiModelProperty("用户id")
    @NotNull
    private Integer userId;

    @ApiModelProperty("日程卡序号")
    @NotBlank
    private  String cardSn;
}
