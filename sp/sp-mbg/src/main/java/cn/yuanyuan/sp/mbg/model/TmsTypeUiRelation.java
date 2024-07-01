package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TmsTypeUiRelation implements Serializable {
    @ApiModelProperty(value = " 类型id")
    private Integer typeId;

    @ApiModelProperty(value = "1为输入 0为输出")
    private Byte isInput;

    @ApiModelProperty(value = "ui id")
    private Integer uiId;

    private static final long serialVersionUID = 1L;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Byte getIsInput() {
        return isInput;
    }

    public void setIsInput(Byte isInput) {
        this.isInput = isInput;
    }

    public Integer getUiId() {
        return uiId;
    }

    public void setUiId(Integer uiId) {
        this.uiId = uiId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeId=").append(typeId);
        sb.append(", isInput=").append(isInput);
        sb.append(", uiId=").append(uiId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}