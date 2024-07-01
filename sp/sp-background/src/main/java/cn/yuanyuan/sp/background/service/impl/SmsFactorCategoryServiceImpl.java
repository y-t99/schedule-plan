package cn.yuanyuan.sp.background.service.impl;

import cn.yuanyuan.sp.background.dao.SmsFactorCategoryDao;
import cn.yuanyuan.sp.background.dto.FactorCategoryParameter;
import cn.yuanyuan.sp.background.dto.FactorCategoryWithFactors;
import cn.yuanyuan.sp.background.service.SmsFactorCategoryService;
import cn.yuanyuan.sp.common.exception.DeleteForbidException;
import cn.yuanyuan.sp.common.exception.InsertForbidException;
import cn.yuanyuan.sp.common.exception.UpdateForbidException;
import cn.yuanyuan.sp.mbg.mapper.SmsFactorCategoryMapper;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategory;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategoryExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsFactorCategoryServiceImpl implements SmsFactorCategoryService {

    final SmsFactorCategoryMapper factorCategoryMapper;
    final SmsFactorCategoryDao factorCategoryDao;

    public SmsFactorCategoryServiceImpl(SmsFactorCategoryMapper factorCategoryMapper, SmsFactorCategoryDao factorCategoryDao) {
        this.factorCategoryMapper = factorCategoryMapper;
        this.factorCategoryDao = factorCategoryDao;
    }

    @Override
    public List<SmsFactorCategory> queryAll() {
        SmsFactorCategoryExample condition = new SmsFactorCategoryExample();
        return factorCategoryMapper.selectByExample(condition);
    }

    @Override
    public List<FactorCategoryWithFactors> queryAllWithFactors() {
        return factorCategoryDao.selectAllWithFactors();
    }

    @Override
    public SmsFactorCategory queryByName(String name) {
        SmsFactorCategoryExample condition = new SmsFactorCategoryExample();
        condition.createCriteria().andNameEqualTo(name);
        List<SmsFactorCategory> smsFactorCategories = factorCategoryMapper.selectByExample(condition);
        if (smsFactorCategories == null || smsFactorCategories.size() == 0) {
            return null;
        }
        return smsFactorCategories.get(0);
    }

    @Override
    public int deleteById(int id) {
        // 1. 查询是否有因素，如果有则不能删除
        SmsFactorCategory smsFactorCategory = factorCategoryMapper.selectByPrimaryKey(id);
        if (smsFactorCategory.getCount() != 0) {
            throw new DeleteForbidException("该因素库下有因素元素，无法删除");
        }
        // 2. 删除
        return factorCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int create(FactorCategoryParameter parameter) {
        // 1. 判断是否有因素分类名称相同
        String name = parameter.getName();
        if (isNameExist(name)) {
            throw new InsertForbidException("已存在分类名称");
        }
        // 2. 插入新纪录
        SmsFactorCategory factorCategory = new SmsFactorCategory();
        BeanUtils.copyProperties(parameter, factorCategory);
        factorCategory.setCount(0);
        return factorCategoryMapper.insertSelective(factorCategory);
    }

    @Override
    public int updateNameById(Integer id, String name) {
        if (isNameExist(name)) {
            throw new UpdateForbidException("已存在分类名称");
        }
        SmsFactorCategory updateFiled = new SmsFactorCategory();
        updateFiled.setId(id);
        updateFiled.setName(name);
        return factorCategoryMapper.updateByPrimaryKeySelective(updateFiled);
    }

    private boolean isNameExist(String name) {
        SmsFactorCategoryExample queryCondition = new SmsFactorCategoryExample();
        queryCondition.createCriteria().andNameEqualTo(name);
        long count = factorCategoryMapper.countByExample(queryCondition);
        return count != 0;
    }

}
