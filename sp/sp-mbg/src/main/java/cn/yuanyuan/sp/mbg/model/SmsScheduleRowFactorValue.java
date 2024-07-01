package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmsScheduleRowFactorValue implements Serializable {
    @ApiModelProperty(value = "ID号")
    private Integer id;

    @ApiModelProperty(value = "数据记录ID号")
    private Integer rowId;

    @ApiModelProperty(value = "因素ID号")
    private Integer factorId;

    @ApiModelProperty(value = "因素元素值列表;元素间用逗号隔开")
    private String factorValues;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public Integer getFactorId() {
        return factorId;
    }

    public void setFactorId(Integer factorId) {
        this.factorId = factorId;
    }

    public String getFactorValues() {
        return factorValues;
    }

    public void setFactorValues(String factorValues) {
        this.factorValues = factorValues;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rowId=").append(rowId);
        sb.append(", factorId=").append(factorId);
        sb.append(", factorValues=").append(factorValues);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}