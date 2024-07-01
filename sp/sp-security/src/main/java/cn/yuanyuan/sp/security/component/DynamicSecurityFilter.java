package cn.yuanyuan.sp.security.component;

import cn.yuanyuan.sp.security.config.IgnoreUrlsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 动态权限过滤器，用于实现基于路径的动态权限过滤。
 *
 *
 */
public class DynamicSecurityFilter extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;
    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Autowired
    public void setMyAccessDecisionManager(DynamicAccessDecisionManager dynamicAccessDecisionManager) {
        super.setAccessDecisionManager(dynamicAccessDecisionManager);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        FilterInvocation fi = new FilterInvocation(servletRequest, servletResponse, filterChain);
        //OPTIONS请求直接放行
        if (request.getMethod().equals(HttpMethod.OPTIONS.toString())) {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
            return;
        }
        //白名单请求直接放行
        PathMatcher pathMatcher = new AntPathMatcher();
        for (String path : ignoreUrlsConfig.getUrls()) {
            if (pathMatcher.match(path, request.getRequestURI())) {
                fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
                return;
            }
        }
        // 此处会调用AccessDecisionManager中的decide方法进行鉴权操作
        // 在前置处理器中通过AccessDecisionManager调用AccessDecisionVoter进行投票，进而做出相应的决策。
        //（1）首先调用obtainSecurityMetadataSource方法获取SecurityMetadataSource对象，
        //     然后调用其getAttributes方法获取受保护对象所需要的权限。
        //     如果获取到的值为空，此时：
        //     如果rejectPublicInvocations变量为true，表示受保护的对象拒绝公开调用，则直接抛出异常；
        //     如果rejectPublicInvocations变量为false，表示受保护对象允许公开访问，此时直接返回null即可。
        //（2）接下来到SecurityContextHolder中查看当前用户的认证信息是否存在。
        //（3）调用authenticateIfRequired方法检查当前用户是否已经登录。
        //（4）调用accessDecisionManager.decide方法进行决策，
        //     该方法中会调用投票器进行投票，
        //     如果该方法执行抛出异常，则说明权限不足。
        //（5）接下来调用runAsManager.buildRunAs方法去临时替换用户身份，
        //     不过默认情况下，runAsManager的实例是NullRunAsManager，
        //     即不做任何替换，所以返回的runAs对象为null。
        //     如果runAs为null，则直接创建一个InterceptorStatusToken对象返回即可；
        //     否则将SecurityContextHolder中保存的用户信息修改为替换的用户对象，
        //     然后返回一个InterceptorStatusToken对象。
        //     InterceptorStatusToken对象中保存了当前用户的SecurityContext对象，
        //     假如进行了临时用户替换，在替换完成后，最终还是要恢复成当前用户身份的，
        //     恢复的依据就是InterceptorStatusToken中保存的原始SecurityContext对象。
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return dynamicSecurityMetadataSource;
    }

}
