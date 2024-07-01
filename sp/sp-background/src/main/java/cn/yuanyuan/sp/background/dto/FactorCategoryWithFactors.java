package cn.yuanyuan.sp.background.dto;

import cn.yuanyuan.sp.mbg.model.SmsFactor;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@ApiModel("因素分类及其因素信息")
public class FactorCategoryWithFactors extends SmsFactorCategory {

    @ApiModelProperty("分类因素")
    @Getter
    @Setter
    private List<SmsFactor> factors;

}
