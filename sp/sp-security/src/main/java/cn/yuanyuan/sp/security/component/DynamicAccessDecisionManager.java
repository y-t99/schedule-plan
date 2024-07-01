package cn.yuanyuan.sp.security.component;

import cn.hutool.core.collection.CollUtil;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * 动态权限决策管理器，用于判断用户是否有访问权限。
 *
 * 投票器是Spring Security权限管理功能中的一个组件，
 * 顾名思义，投票器的作用就是针对是否允许某一个操作进行投票。
 * 当请求的URL地址被拦截下来之后，或者当调用的方法被AOP拦截下来之后，
 * 都会调用投票器对当前操作进行投票，以便决定是否允许当前操作。
 *
 * 决策器由AccessDecisionManager负责，
 * AccessDecisionManager会同时管理多个投票器，
 * 由AccessDecisionManager调用投票器进行投票，
 * 然后根据投票结果做出相应的决策，
 * 所以我们将AccessDecisionManager也称作是一个决策管理器。
 *
 *
 */
public class DynamicAccessDecisionManager implements AccessDecisionManager {

    /**
     * 是核心的决策方法，在这个方法中判断是否允许当前URL或者方法的调用，
     * 如果不允许，则会抛出AccessDeniedException异常。
     * @param authentication
     * @param object
     * @param configAttributes
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // 当接口未被配置资源时直接放行
        if (CollUtil.isEmpty(configAttributes)) {
            return;
        }
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute configAttribute = iterator.next();
            //将访问所需资源或用户拥有资源进行比对
            String needAuthority = configAttribute.getAttribute();
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needAuthority.trim().equals(grantedAuthority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("抱歉，您没有访问权限");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
