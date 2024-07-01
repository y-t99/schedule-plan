package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmsFactor implements Serializable {
    @ApiModelProperty(value = "ID号")
    private Integer id;

    @ApiModelProperty(value = "因素类别ID号")
    private Integer factorCategoryId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "值选择类型;1-单选，2-多学")
    private Integer selectType;

    @ApiModelProperty(value = "值获取方式;1-列表，2-手工输入")
    private Integer inputType;

    @ApiModelProperty(value = "可选值列表;可选值列表，逗号隔开")
    private String inputList;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = " 输入提示")
    private String tip;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFactorCategoryId() {
        return factorCategoryId;
    }

    public void setFactorCategoryId(Integer factorCategoryId) {
        this.factorCategoryId = factorCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getInputList() {
        return inputList;
    }

    public void setInputList(String inputList) {
        this.inputList = inputList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", factorCategoryId=").append(factorCategoryId);
        sb.append(", name=").append(name);
        sb.append(", selectType=").append(selectType);
        sb.append(", inputType=").append(inputType);
        sb.append(", inputList=").append(inputList);
        sb.append(", sort=").append(sort);
        sb.append(", tip=").append(tip);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}