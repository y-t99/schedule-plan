package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TmsAttribute implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "属性代码")
    private String attributeCode;

    @ApiModelProperty(value = "属性名称")
    private String attributeName;

    @ApiModelProperty(value = "描述")
    private String comment;

    @ApiModelProperty(value = " 属性值是否可以为空 0为可为空 1为不能为空")
    private Byte isNull;

    @ApiModelProperty(value = "属性类型，有String、Object、List，Object还有属性，list有成员类。")
    private String attributType;

    @ApiModelProperty(value = "属性属于哪个类，id为0代表为字段类。")
    private Integer objectId;

    @ApiModelProperty(value = "类名称，为了防止自联表获取所属类名称。不可用于属性查找类名称。")
    private String objectText;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Byte getIsNull() {
        return isNull;
    }

    public void setIsNull(Byte isNull) {
        this.isNull = isNull;
    }

    public String getAttributType() {
        return attributType;
    }

    public void setAttributType(String attributType) {
        this.attributType = attributType;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getObjectText() {
        return objectText;
    }

    public void setObjectText(String objectText) {
        this.objectText = objectText;
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
        sb.append(", comment=").append(comment);
        sb.append(", isNull=").append(isNull);
        sb.append(", attributType=").append(attributType);
        sb.append(", objectId=").append(objectId);
        sb.append(", objectText=").append(objectText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}