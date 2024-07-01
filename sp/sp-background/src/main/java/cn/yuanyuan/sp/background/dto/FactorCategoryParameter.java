package cn.yuanyuan.sp.background.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel("因素分类创建、更改时参数")
@Data
public class FactorCategoryParameter {

    @ApiModelProperty("因素分类名称")
    @NotBlank(message = "name不可为空字符串")
    private String name;

}
