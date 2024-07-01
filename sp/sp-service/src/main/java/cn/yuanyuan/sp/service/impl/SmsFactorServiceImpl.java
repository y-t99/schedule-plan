package cn.yuanyuan.sp.service.impl;

import cn.yuanyuan.sp.api.dto.FactorWithCategory;
import cn.yuanyuan.sp.api.service.ISmsFactorService;
import cn.yuanyuan.sp.mbg.mapper.SmsFactorCategoryMapper;
import cn.yuanyuan.sp.mbg.mapper.SmsFactorMapper;
import cn.yuanyuan.sp.mbg.model.SmsFactor;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategory;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategoryExample;
import cn.yuanyuan.sp.mbg.model.SmsFactorExample;
import cn.yuanyuan.sp.service.dao.SmsFactorDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@DubboService(version = "${sp.service.version}")
public class SmsFactorServiceImpl implements ISmsFactorService {

    final SmsFactorCategoryMapper factorCategoryMapper;
    final SmsFactorMapper factorMapper;
    final SmsFactorDao factorDao;

    public SmsFactorServiceImpl(SmsFactorCategoryMapper factorCategoryMapper, SmsFactorMapper factorMapper, SmsFactorDao factorDao) {
        this.factorCategoryMapper = factorCategoryMapper;
        this.factorMapper = factorMapper;
        this.factorDao = factorDao;
    }

    @Override
    public List<FactorWithCategory> queryByCategoryId(Integer categoryId) {
        return factorDao.selectFactorListWithCategoryById(categoryId);
    }

    @Override
    public List<FactorWithCategory> queryByCategoryName(String categoryName) {
        // 1. 查找对应分类id
        SmsFactorCategoryExample categoryQueryCondition = new SmsFactorCategoryExample();
        categoryQueryCondition.createCriteria().andNameEqualTo(categoryName);
        List<SmsFactorCategory> smsFactorCategories = factorCategoryMapper.selectByExample(categoryQueryCondition);
        if (smsFactorCategories.size() == 0) {
            return Collections.emptyList();
        }
        // 2. 获取分类下因素集合
        SmsFactorCategory factorCategory = smsFactorCategories.get(0);
        return queryByCategoryId(factorCategory.getId());
    }

    @Override
    public FactorWithCategory queryById(Integer id) {
        return factorDao.selectFactorWithCategoryByPK(id);
    }

    @Override
    public List<FactorWithCategory> queryByName(String name) {
        return factorDao.selectFactorListWithCategoryByName(name);
    }

    @Override
    public List<SmsFactor> getFactorMeta(int factorCategoryId) {
        SmsFactorExample condition = new SmsFactorExample();
        condition.createCriteria().andFactorCategoryIdEqualTo(factorCategoryId);
        return factorMapper.selectByExample(condition);
    }

    @Override
    public List<FactorWithCategory> queryAll() {

        return factorDao.selectAllFactorsWithCategory();
    }

}
