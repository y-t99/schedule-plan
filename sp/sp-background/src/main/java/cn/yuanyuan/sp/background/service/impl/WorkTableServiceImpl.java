package cn.yuanyuan.sp.background.service.impl;

import cn.yuanyuan.sp.background.service.WorkTableService;
import cn.yuanyuan.sp.mbg.mapper.UmsUserMapper;
import cn.yuanyuan.sp.mbg.model.UmsUser;
import cn.yuanyuan.sp.mbg.model.UmsUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkTableServiceImpl implements WorkTableService {

    @Autowired
    UmsUserMapper userMapper;

    @Override
    public int toDoCount() {
        // ：user表中count(statue = 0)
        UmsUserExample condition = new UmsUserExample();
        condition.createCriteria().andStatueEqualTo(0);
        return (int) userMapper.countByExample(condition);
    }

    @Override
    public int messageCount() {
        // ：user表中count(is_notify = 1 && statue != 0)
        UmsUserExample condition = new UmsUserExample();
        condition.createCriteria().andStatueNotEqualTo(0).andIsNotifyEqualTo(1);
        return (int) userMapper.countByExample(condition);
    }

    @Override
    public List<UmsUser> verifications() {
        // ：user表中statue = 0 limit 2
        UmsUserExample condition = new UmsUserExample();
        condition.createCriteria().andStatueEqualTo(0);
        List<UmsUser> umsUsers = userMapper.selectByExample(condition);
        if (umsUsers.size() > 2) {
            umsUsers = umsUsers.subList(0, 2);
        }
        return umsUsers;
    }

    @Override
    public List<String> agreementNotifies() {
        // ：statue = 1 && is_notify = 1 limit 3
        UmsUserExample condition = new UmsUserExample();
        condition.createCriteria().andStatueEqualTo(1).andIsNotifyEqualTo(1);
        List<UmsUser> umsUsers = userMapper.selectByExample(condition);
        if (umsUsers.size() > 3) {
            umsUsers = umsUsers.subList(0, 3);
        }
        return umsUsers.stream().map(UmsUser::getAccount).collect(Collectors.toList());
    }

    @Override
    public String disagreementNotifies() {
        // ：statue = 0 && is_notify = 1 limit 1
        UmsUserExample condition = new UmsUserExample();
        condition.createCriteria().andStatueEqualTo(0).andIsNotifyEqualTo(1);
        List<UmsUser> umsUsers = userMapper.selectByExample(condition);
        String result = null;
        if (umsUsers.size() > 1) {
            result = umsUsers.get(0).getAccount();
        }
        return result;
    }

    @Override
    public Integer approval(Integer id, Integer statue) {
        UmsUser user = new UmsUser();
        user.setId(id);
        user.setStatue(statue);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer closeNotify(Integer id) {
        UmsUser user = new UmsUser();
        user.setId(id);
        user.setIsNotify(0);
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
