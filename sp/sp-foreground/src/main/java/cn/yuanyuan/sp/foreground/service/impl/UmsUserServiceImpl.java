package cn.yuanyuan.sp.foreground.service.impl;

import cn.yuanyuan.sp.foreground.domain.UserAccountDetail;
import cn.yuanyuan.sp.foreground.exception.AccountIsExistExcetion;
import cn.yuanyuan.sp.foreground.service.UmsUserService;
import cn.yuanyuan.sp.mbg.constant.FieldValueEnum;
import cn.yuanyuan.sp.mbg.mapper.UmsUserMapper;
import cn.yuanyuan.sp.mbg.model.UmsUser;
import cn.yuanyuan.sp.mbg.model.UmsUserExample;
import cn.yuanyuan.sp.security.exception.AccountForbidException;
import cn.yuanyuan.sp.security.exception.AccountPasswordErrorException;
import cn.yuanyuan.sp.security.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UmsUserServiceImpl implements UmsUserService {

    final UmsUserMapper umsUserMapper;
    final PasswordEncoder passwordEncoder;
    final JwtTokenUtil jwtTokenUtil;

    public UmsUserServiceImpl(
            UmsUserMapper umsUserMapper,
            PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.umsUserMapper = umsUserMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    /**
     * 根据账号获取对象
     *
     * @param username 账号
     * @return 用户对象
     * @throws UsernameNotFoundException 认证失败
     */
    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<UmsUser> umsUser = getByAccount(username);
        if (umsUser.isPresent()) {
            return new UserAccountDetail(umsUser.get());
        }
        throw new UsernameNotFoundException("用户名或者密码错误");
    }

    @Override
    public Optional<UmsUser> getByAccount(String account) {
        UmsUserExample condition = new UmsUserExample();
        condition.createCriteria().andAccountEqualTo(account);
        List<UmsUser> umsUsers = umsUserMapper.selectByExample(condition);
        if (umsUsers.size() == 1) {
            UmsUser user = umsUsers.get(0);
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public Optional<UmsUser> getByName(String name) {

        return null;
    }

    @Override
    public Optional<String> login(String account, String password) {
        Optional<String> token = Optional.empty();
        try {
            UserDetails userDetails = loadUserByUsername(account);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new AccountPasswordErrorException("密码错误");
            }
            if (!userDetails.isEnabled()) {
                throw new AccountForbidException("账号禁用");
            }
            // 用户的认证信息主要由Authentication的实现类来保存。
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = Optional.of(jwtTokenUtil.generateToken(userDetails));
        } catch (AuthenticationException e) {
            log.info("登录异常：{}", e.getMessage());
        }
        return token;
    }

    @Override
    public UmsUser register(String account, String password, String name) throws AccountIsExistExcetion {
        // 查看是否有相同账号的记录
        UmsUserExample condition = new UmsUserExample();
        condition.createCriteria().andAccountEqualTo(account);
        List<UmsUser> umsUsers = umsUserMapper.selectByExample(condition);
        if (umsUsers.size() == 1) {
            throw new AccountIsExistExcetion();
        }
        UmsUser user = new UmsUser();
        user.setAccount(account);
        user.setName(name);
        user.setIsForbid(FieldValueEnum.UMS_USER_NOT_FORBID.getStatus());
        user.setStatue(0);
        user.setIsNotify(1);
        user.setType(0);
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(password);
        user.setPassword(encodePassword);
        umsUserMapper.insert(user);
        return user;
    }
}
