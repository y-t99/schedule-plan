package cn.yuanyuan.sp.api.service;

import cn.yuanyuan.sp.api.dto.FactorCategoryWithFactors;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategory;

import java.util.List;

public interface ISmsFactorCategoryService {
    /**
     * 查询所有因素分类信息
     * @return 因素分类信息列表
     */
    List<SmsFactorCategory> queryAll();

    /**
     * 查询所有因素分类及其因素信息
     * @return 因素分类及其因素信息列表
     */
    List<FactorCategoryWithFactors> queryAllWithFactors();

    /**
     * 根据分类名称查找类别信息
     * @param name 分类名称
     * @return 类别信息
     */
    SmsFactorCategory queryByName(String name);
}
