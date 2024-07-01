package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TmsStructureDefinition implements Serializable {
    @ApiModelProperty(value = "记录id")
    private Integer id;

    @ApiModelProperty(value = "用户id;自定义表结构所属的用户id")
    private Integer userId;

    @ApiModelProperty(value = "表名称;表名称")
    private String tableName;

    @ApiModelProperty(value = " 表描述")
    private String comment;

    @ApiModelProperty(value = "表结构;json对象，表结构的定义，属性及其属性值在表`attribute`和`attribute_definition_dict`中查看")
    private String tableStructureJson;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTableStructureJson() {
        return tableStructureJson;
    }

    public void setTableStructureJson(String tableStructureJson) {
        this.tableStructureJson = tableStructureJson;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", tableName=").append(tableName);
        sb.append(", comment=").append(comment);
        sb.append(", tableStructureJson=").append(tableStructureJson);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}