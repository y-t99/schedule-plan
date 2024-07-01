package cn.yuanyuan.sp.foreground.dto;

import cn.yuanyuan.sp.api.dto.FactorCategoryWithFactors;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategory;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel("日程填写需要的元数据信息")
@Data
public class ScheduleRowMeta {
    private List<SmsFactorCategory> smsFactorCategories;
    private List<FactorCategoryWithFactors> factorCategoryWithFactors;
}
