package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmsScheduleBaseRow implements Serializable {
    @ApiModelProperty(value = "ID号")
    private Integer id;

    @ApiModelProperty(value = "card的ID号")
    private Integer cardId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "时间点")
    private Long timePoint;

    @ApiModelProperty(value = "时长")
    private Integer duration;

    @ApiModelProperty(value = "时长展示格式;0-小时，1-分钟，2-秒，3-时间点 ")
    private Integer durationView;

    @ApiModelProperty(value = "关联row的ID号")
    private Integer relationId;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "是否拖延 0-未确定状态 1-拖延 2-未拖延")
    private Integer isDelay;

    @ApiModelProperty(value = "是否完成")
    private Integer isFinish;

    @ApiModelProperty(value = "优先级;0-普通（默认）1-重要紧急 2-紧急不重要 3-重要不紧急 4-不重要不紧急")
    private Integer priority;

    @ApiModelProperty(value = "日程主题ID号")
    private Integer scheduleFactorCategoryId;

    @ApiModelProperty(value = "日程主题title")
    private String scheduleFactorCategoryName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(Long timePoint) {
        this.timePoint = timePoint;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDurationView() {
        return durationView;
    }

    public void setDurationView(Integer durationView) {
        this.durationView = durationView;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsDelay() {
        return isDelay;
    }

    public void setIsDelay(Integer isDelay) {
        this.isDelay = isDelay;
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getScheduleFactorCategoryId() {
        return scheduleFactorCategoryId;
    }

    public void setScheduleFactorCategoryId(Integer scheduleFactorCategoryId) {
        this.scheduleFactorCategoryId = scheduleFactorCategoryId;
    }

    public String getScheduleFactorCategoryName() {
        return scheduleFactorCategoryName;
    }

    public void setScheduleFactorCategoryName(String scheduleFactorCategoryName) {
        this.scheduleFactorCategoryName = scheduleFactorCategoryName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cardId=").append(cardId);
        sb.append(", title=").append(title);
        sb.append(", timePoint=").append(timePoint);
        sb.append(", duration=").append(duration);
        sb.append(", durationView=").append(durationView);
        sb.append(", relationId=").append(relationId);
        sb.append(", description=").append(description);
        sb.append(", isDelay=").append(isDelay);
        sb.append(", isFinish=").append(isFinish);
        sb.append(", priority=").append(priority);
        sb.append(", scheduleFactorCategoryId=").append(scheduleFactorCategoryId);
        sb.append(", scheduleFactorCategoryName=").append(scheduleFactorCategoryName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}