package cn.yuanyuan.sp.background.dto;

import cn.yuanyuan.sp.mbg.model.SmsFactor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel("因素详细信息")
public class FactorWithCategory extends SmsFactor {

    @Getter
    @Setter
    @ApiModelProperty("类别名称")
    private String categoryName;

    @Getter
    @Setter
    @ApiModelProperty("类别名称")
    private Integer factorCategoryId;

}
