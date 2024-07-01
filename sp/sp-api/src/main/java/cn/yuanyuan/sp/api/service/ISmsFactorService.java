package cn.yuanyuan.sp.api.service;

import cn.yuanyuan.sp.api.dto.FactorWithCategory;
import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.mbg.model.SmsFactor;

import java.util.List;

/**
 * 因素信息查询
 */
public interface ISmsFactorService {


    /**
     * 根据因素分类id获取同类因素
     *
     * @param categoryId 因素分类id
     * @return 同类因素列表
     */
    List<FactorWithCategory> queryByCategoryId(Integer categoryId);

    /**
     * 根据因素分类名称获取同类因素
     *
     * @param categoryName 因素分类名称
     * @return 同类因素列表
     */
    List<FactorWithCategory> queryByCategoryName(String categoryName);


    /**
     * 根据因素id查找因素详细信息
     *
     * @param id 因素id
     * @return 因素详细信息
     */
    FactorWithCategory queryById(Integer id);

    /**
     * 查找所有因素详细信息
     * @return 所有因素详细信息
     */
    List<FactorWithCategory> queryAll();

    /**
     * 根据因素名称查找因素详细信息
     *
     * @param name 因素名称
     * @return 因素详细信息
     */
    List<FactorWithCategory> queryByName(String name);

    /**
     *
     * @param factorCategoryId 因素列别ID号
     * @return
     */
    List<SmsFactor> getFactorMeta(int factorCategoryId);
}
