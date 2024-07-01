package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TmsDataStorage implements Serializable {
    @ApiModelProperty(value = "记录id")
    private Integer id;

    @ApiModelProperty(value = "表结构id")
    private Integer tableStructureId;

    @ApiModelProperty(value = "记录数据;列表对象")
    private String rowList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableStructureId() {
        return tableStructureId;
    }

    public void setTableStructureId(Integer tableStructureId) {
        this.tableStructureId = tableStructureId;
    }

    public String getRowList() {
        return rowList;
    }

    public void setRowList(String rowList) {
        this.rowList = rowList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tableStructureId=").append(tableStructureId);
        sb.append(", rowList=").append(rowList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}