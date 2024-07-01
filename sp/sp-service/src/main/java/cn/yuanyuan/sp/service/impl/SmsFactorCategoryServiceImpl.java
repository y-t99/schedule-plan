package cn.yuanyuan.sp.service.impl;

import cn.yuanyuan.sp.api.dto.FactorCategoryWithFactors;
import cn.yuanyuan.sp.api.service.ISmsFactorCategoryService;
import cn.yuanyuan.sp.common.exception.DeleteForbidException;
import cn.yuanyuan.sp.common.exception.InsertForbidException;
import cn.yuanyuan.sp.common.exception.UpdateForbidException;
import cn.yuanyuan.sp.mbg.mapper.SmsFactorCategoryMapper;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategory;
import cn.yuanyuan.sp.mbg.model.SmsFactorCategoryExample;
import cn.yuanyuan.sp.service.dao.SmsFactorCategoryDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@DubboService(version = "${sp.service.version}")
public class SmsFactorCategoryServiceImpl implements ISmsFactorCategoryService {

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

}
