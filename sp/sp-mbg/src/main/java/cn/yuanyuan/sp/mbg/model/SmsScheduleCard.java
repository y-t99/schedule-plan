package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmsScheduleCard implements Serializable {
    @ApiModelProperty(value = "ID号")
    private Integer id;

    @ApiModelProperty(value = "计划卡序列号")
    private String cardSn;

    @ApiModelProperty(value = "用户ID号")
    private Integer userId;

    @ApiModelProperty(value = "PNSNS情绪值，允许多选")
    private String pnsns;

    @ApiModelProperty(value = "合理性;1-不合理 2-较不合理 3-较合理 4-合理 5-非常合理")
    private Integer reasonableness;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardSn() {
        return cardSn;
    }

    public void setCardSn(String cardSn) {
        this.cardSn = cardSn;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPnsns() {
        return pnsns;
    }

    public void setPnsns(String pnsns) {
        this.pnsns = pnsns;
    }

    public Integer getReasonableness() {
        return reasonableness;
    }

    public void setReasonableness(Integer reasonableness) {
        this.reasonableness = reasonableness;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cardSn=").append(cardSn);
        sb.append(", userId=").append(userId);
        sb.append(", pnsns=").append(pnsns);
        sb.append(", reasonableness=").append(reasonableness);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}