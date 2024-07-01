package cn.yuanyuan.sp.background.dto;

import cn.yuanyuan.sp.background.validator.FlagValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("因素创建参数")
@Data
public class FactorParameter {

    @ApiModelProperty("父类id")
    @NotNull
    private Integer factorCategoryId;

    @NotBlank
    @ApiModelProperty("名称")
    private String name;

    @FlagValidator({"1","2"})
    @ApiModelProperty("值选择类型 1-单选 2-多选")
    private Integer selectType;

    @FlagValidator({"1","2"})
    @ApiModelProperty("值获取方式；1-列表 2-手工输入")
    private Integer inputType;

    @ApiModelProperty("可选值列表，属性逗号隔开")
    private String inputList;

    @ApiModelProperty("排序值，越大越靠前")
    private int sort;
}
