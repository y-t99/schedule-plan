package cn.yuanyuan.sp.background.service;

import cn.yuanyuan.sp.background.dto.FactorParameter;
import cn.yuanyuan.sp.background.dto.FactorUpdateParameter;
import cn.yuanyuan.sp.background.dto.FactorWithCategory;
import cn.yuanyuan.sp.mbg.model.SmsFactor;

import java.util.List;

public interface SmsFactorService {

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
     * 根据因素id删除因素
     *
     * @param id 因素id
     * @return 影响函数
     */
    int deleteById(Integer id);

    /**
     * 创建新的因素
     *
     * @param parameter 属性集合
     * @return 影响行数
     */
    int create(FactorParameter parameter);

    /**
     * 根据因素名称查找因素详细信息
     *
     * @param name 因素名称
     * @return 因素详细信息
     */
    List<FactorWithCategory> queryByName(String name);

    /**
     * 更改因素信息
     *
     * @param id        因素id号
     * @param parameter 属性集合
     * @return 影响行数
     */
    int updateById(Integer id, FactorUpdateParameter parameter);

    /**
     * 查找所有因素详细信息
     * @return 所有因素详细信息
     */
    List<FactorWithCategory> queryAll();
}
