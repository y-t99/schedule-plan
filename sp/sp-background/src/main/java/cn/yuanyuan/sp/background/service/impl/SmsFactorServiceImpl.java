package cn.yuanyuan.sp.background.service.impl;

import cn.yuanyuan.sp.background.dao.SmsFactorDao;
import cn.yuanyuan.sp.background.dto.FactorParameter;
import cn.yuanyuan.sp.background.dto.FactorUpdateParameter;
import cn.yuanyuan.sp.background.dto.FactorWithCategory;
import cn.yuanyuan.sp.background.service.SmsFactorService;
import cn.yuanyuan.sp.common.exception.InsertForbidException;
import cn.yuanyuan.sp.common.exception.UpdateForbidException;
import cn.yuanyuan.sp.mbg.mapper.SmsFactorCategoryMapper;
import cn.yuanyuan.sp.mbg.mapper.SmsFactorMapper;
import cn.yuanyuan.sp.mbg.model.SmsFactor;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategory;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategoryExample;
import cn.yuanyuan.sp.mbg.model.SmsFactorExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class SmsFactorServiceImpl implements SmsFactorService {

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
    @Transactional
    public int deleteById(Integer id) {
        // 1. 修改分类count数量
        SmsFactor factor = factorMapper.selectByPrimaryKey(id);
        SmsFactorCategory factorCategory = factorCategoryMapper.selectByPrimaryKey(factor.getFactorCategoryId());
        factorCategory.setCount(factorCategory.getCount() - 1);
        factorCategoryMapper.updateByPrimaryKeySelective(factorCategory);
        // 2. 删除记录
        return factorMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int create(FactorParameter parameter) {
        // 1. 校验是否有所在分类
        Integer categoryId = parameter.getFactorCategoryId();
        SmsFactorCategory factorCategory = factorCategoryMapper.selectByPrimaryKey(categoryId);
        if (factorCategory == null) {
            throw new InsertForbidException("类别不存在");
        }
        // 2. 校验分类下是否有同名因素
        SmsFactorExample queryCondition = new SmsFactorExample();
        queryCondition.createCriteria()
                .andFactorCategoryIdEqualTo(categoryId)
                .andNameEqualTo(parameter.getName());
        long count = factorMapper.countByExample(queryCondition);
        if (count != 0) {
            throw new InsertForbidException("类别下已有改相同名称的因素");
        }
        // 3. 分类下因素数量加一
        factorCategory.setCount(factorCategory.getCount() + 1);
        factorCategoryMapper.updateByPrimaryKey(factorCategory);
        // 4. 插入
        SmsFactor factor = new SmsFactor();
        BeanUtils.copyProperties(parameter, factor);
        factor.setSort(0);
        return factorMapper.insertSelective(factor);
    }

    @Override
    public List<FactorWithCategory> queryByName(String name) {
        return factorDao.selectFactorListWithCategoryByName(name);
    }

    @Override
    @Transactional
    public int updateById(Integer id, FactorUpdateParameter parameter) {
        SmsFactor factor = factorMapper.selectByPrimaryKey(id);
        // 1. id不存在返回影响行数为0
        if (factor == null) {
            return 0;
        }
        // 2. 判断是否为更改类别
        if (parameter.getFactorCategoryId() != null &&
                !factor.getFactorCategoryId().equals(parameter.getFactorCategoryId())) {
            SmsFactorCategory newCategory = factorCategoryMapper.selectByPrimaryKey(parameter.getFactorCategoryId());
            // 更改类别不存在抛异常。
            if (newCategory == null) {
                throw new UpdateForbidException("要更换的类别不存在");
            }
            SmsFactorCategory oldCategory = factorCategoryMapper.selectByPrimaryKey(factor.getFactorCategoryId());
            newCategory.setCount(newCategory.getCount() + 1);
            oldCategory.setCount(oldCategory.getCount() - 1);
            // 更换类别并对应类别因素数据进行更改
            factorCategoryMapper.updateByPrimaryKey(newCategory);
            factorCategoryMapper.updateByPrimaryKey(oldCategory);
            factor.setFactorCategoryId(parameter.getFactorCategoryId());
        }
        // 3. 判断是否更改选择类型
        if (parameter.getSelectType() != null &&
            !factor.getSelectType().equals(parameter.getSelectType())) {
            if (parameter.getSelectType() == 1) {
                factor.setSelectType(1);
            } else if(parameter.getSelectType() == 2) {
                // 查询是否有存在多选值的记录，有则抛出异常。
                // ...
                factor.setSelectType(2);
            }
        }
        // 4. 判断是否需要更改值获取方式
        if (parameter.getInputType() != null) {
            factor.setInputType(parameter.getInputType());
        }
        // 5. 判断是否需要更改值可选列表
        if (parameter.getInputList() != null) {
            factor.setInputList(parameter.getInputList());
        }
        factor.setName(parameter.getName());
        factor.setSort(parameter.getSort());
        return factorMapper.updateByPrimaryKeySelective(factor);
    }

    @Override
    public List<FactorWithCategory> queryAll() {

        return factorDao.selectAllFactorsWithCategory();
    }

}
