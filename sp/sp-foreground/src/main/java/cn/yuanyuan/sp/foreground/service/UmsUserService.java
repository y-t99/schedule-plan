package cn.yuanyuan.sp.foreground.service;

import cn.yuanyuan.sp.foreground.exception.AccountIsExistExcetion;
import cn.yuanyuan.sp.mbg.model.UmsUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UmsUserService {

    UserDetails loadUserByUsername(String username);

    Optional<UmsUser> getByAccount(String account);

    Optional<UmsUser> getByName(String name);

    /**
     * 登录校验
     *
     * @param account   账号
     * @param password 密码
     * @return token令牌
     */
    Optional<String> login(String account, String password);

    @Transactional
    UmsUser register(String account, String password, String name) throws AccountIsExistExcetion;
}
