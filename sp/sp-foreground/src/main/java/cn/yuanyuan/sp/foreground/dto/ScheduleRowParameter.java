package cn.yuanyuan.sp.foreground.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@ApiModel("日程记录创建参数")
@Data
public class ScheduleRowParameter {

    @ApiModelProperty(value = "card的ID号")
    @NotNull
    private Integer cardId;

    @ApiModelProperty(value = "标题")
    @NotNull
    private String title;

    @ApiModelProperty(value = "时间点")
    @NotNull
    private Long timePoint;

    @ApiModelProperty(value = "时长")
    private Integer duration;

    @ApiModelProperty(value = "关联row的ID号")
    private Integer relationId;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "优先级;0-普通（默认）1-重要紧急 2-紧急不重要 3-重要不紧急 4-不重要不紧急")
    private Integer priority;

    @ApiModelProperty(value = "日程主题ID号")
    private Integer scheduleFactorCategoryId;

    @ApiModelProperty(value = "日程主题title")
    private String scheduleFactorCategoryName;

    @ApiModelProperty(value = "时长展示格式;0-小时，1-分钟，2-秒，3-时间点 ")
    private Integer durationView;
}
