package cn.yuanyuan.sp.service.dao;

import cn.yuanyuan.sp.api.dto.FactorWithCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsFactorDao {

    /**
     * 获取因素详细信息
     * @param id 因素id
     * @return 因素详细信息
     */
    FactorWithCategory selectFactorWithCategoryByPK(@Param("id") Integer id);

    /**
     * 获取因素详细信息
     * @param name 因素名称
     * @return 因素详细信息
     */
    List<FactorWithCategory> selectFactorListWithCategoryByName(@Param("name") String name);

    /**
     * 获取所有因素的纤细信息
     * @return 所有因素的详细信息列表
     */
    List<FactorWithCategory> selectAllFactorsWithCategory();

    /**
     * 获取同类因素详细信息
     * @param categoryId 因素名称
     * @return 同类因素详细信息列表
     */
    List<FactorWithCategory> selectFactorListWithCategoryById(@Param("categoryId")Integer categoryId);
}
