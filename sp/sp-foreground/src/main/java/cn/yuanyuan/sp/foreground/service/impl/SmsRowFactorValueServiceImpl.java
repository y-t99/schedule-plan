package cn.yuanyuan.sp.foreground.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.yuanyuan.sp.foreground.dto.FactorValueDTO;
import cn.yuanyuan.sp.foreground.service.SmsRowFactorValueService;
import cn.yuanyuan.sp.mbg.mapper.SmsScheduleRowFactorValueMapper;
import cn.yuanyuan.sp.mbg.model.SmsScheduleRowFactorValue;
import cn.yuanyuan.sp.mbg.model.SmsScheduleRowFactorValueExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmsRowFactorValueServiceImpl implements SmsRowFactorValueService {

    @Resource
    SmsScheduleRowFactorValueMapper rowFactorValueMapper;

    @Override
    public Integer insertFactorValue(FactorValueDTO factorValue) {
        SmsScheduleRowFactorValue rowFactorValue = new SmsScheduleRowFactorValue();
        BeanUtils.copyProperties(factorValue, rowFactorValue);
        return rowFactorValueMapper.insertSelective(rowFactorValue);
    }

    @Override
    public SmsScheduleRowFactorValue getFactorValue(int rowId) {
        SmsScheduleRowFactorValueExample condition = new SmsScheduleRowFactorValueExample();
        condition.createCriteria().andRowIdEqualTo(rowId);
        List<SmsScheduleRowFactorValue> values = rowFactorValueMapper.selectByExample(condition);
        if (CollUtil.isNotEmpty(values)) {
            return values.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer updateFactorValue(FactorValueDTO factorValue) {
        SmsScheduleRowFactorValue rowFactorValue = new SmsScheduleRowFactorValue();
        BeanUtils.copyProperties(factorValue, rowFactorValue);
        return rowFactorValueMapper.updateByPrimaryKey(rowFactorValue);
    }

}
