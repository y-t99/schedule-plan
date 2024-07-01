package cn.yuanyuan.sp.background.service;

import cn.yuanyuan.sp.background.dto.FactorCategoryParameter;
import cn.yuanyuan.sp.background.dto.FactorCategoryWithFactors;
import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategory;

import java.util.List;

public interface SmsFactorCategoryService {

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

    /**
     * 根据id删除因素分类
     * @param id 因素分类ID号
     * @return 影响行数，正常返回1
     */
    int deleteById(int id);

    /**
     * 创建因素分类
     * @param parameter 因素分类参数
     * @return 影响行数
     */
    int create(FactorCategoryParameter parameter);

    /**
     * 根据id更改因素分类名称
     * @param id    id
     * @param name  新名称
     * @return 影响行数
     */
    int updateNameById(Integer id, String name);

}
