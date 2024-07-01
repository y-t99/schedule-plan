package cn.yuanyuan.sp.service.dao;


import cn.yuanyuan.sp.api.dto.FactorCategoryWithFactors;

import java.util.List;

public interface SmsFactorCategoryDao {

    /**
     * 查询所有因素分类及其因素信息
     * @return 因素分类及其因素信息列表
     */
    List<FactorCategoryWithFactors> selectAllWithFactors();
}
