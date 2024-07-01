package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TmsAttributeDefinitionDict implements Serializable {
    @ApiModelProperty(value = "记录id")
    private Integer id;

    @ApiModelProperty(value = "属性值代码")
    private String attributeCode;

    @ApiModelProperty(value = "属性值名称")
    private String attributeName;

    @ApiModelProperty(value = "属性id")
    private Integer attributetId;

    @ApiModelProperty(value = "注释")
    private String comment;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttributeCode() {
        return attributeCode;
    }

    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Integer getAttributetId() {
        return attributetId;
    }

    public void setAttributetId(Integer attributetId) {
        this.attributetId = attributetId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attributeCode=").append(attributeCode);
        sb.append(", attributeName=").append(attributeName);
        sb.append(", attributetId=").append(attributetId);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}