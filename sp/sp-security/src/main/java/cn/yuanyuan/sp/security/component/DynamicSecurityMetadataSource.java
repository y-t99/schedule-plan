package cn.yuanyuan.sp.security.component;

import cn.hutool.core.util.URLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 动态权限数据源，用于获取动态权限规则
 *
 * 提供受保护对象所需要的权限。
 */
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static Map<String, ConfigAttribute> configAttributeMap = null;
    @Autowired
    private DynamicSecurityService dynamicSecurityService;

    /**
     * 在具体的投票方法vote中，
     * 受保护对象所需要的权限保存在一个Collection<ConfigAttribute>集合中，
     * 集合中的对象是ConfigAttribute，而不是我们所熟知的GrantedAuthority。
     *
     * 集合中的对象是ConfigAttribute接口只有一个getAttribute方法返回具体的权限字符串，
     * 而GrantedAuthority中则是通过getAuthority方法返回用户所具有的权限，两者返回值都是字符串。
     * 所以虽然是ConfigAttribute和GrantedAuthority两个不同的对象，
     * 但是最终是可以比较的。
     */
    @PostConstruct
    public void loadDataSource() {
        configAttributeMap = dynamicSecurityService.loadDataSource();
    }

    public void clearDataSource() {
        configAttributeMap.clear();
        configAttributeMap = null;
    }

    /**
     * 根据传入的安全对象参数返回其所需要的权限。
     * 如果受保护的对象是一个URL地址，
     * 那么传入的参数object就是一个FilterInvocation对象；
     * 如果受保护的是一个方法，
     * 那么传入的参数object就是一个MethodInvocation对象。
     *
     * 在实际开发中，URL地址以及访问它所需要的权限可能保存在数据库中，
     * 此时我们可以自定义类实现FilterInvocationSecurityMetadataSource接口，
     * 然后重写里边的getAttributes方法，
     * 在getAttributes方法中，根据当前请求的URL地址去数据库中查询其所需要的权限，
     * 然后将查询结果封装为相应的ConfigAttribute集合返回即可。
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (configAttributeMap == null) this.loadDataSource();
        List<ConfigAttribute>  configAttributes = new ArrayList<>();
        //获取当前访问的路径
        String url = ((FilterInvocation) o).getRequestUrl();
        String path = URLUtil.getPath(url);
        PathMatcher pathMatcher = new AntPathMatcher();
        Iterator<String> iterator = configAttributeMap.keySet().iterator();
        //获取访问该路径所需资源
        while (iterator.hasNext()) {
            String pattern = iterator.next();
            if (pathMatcher.match(pattern, path)) {
                configAttributes.add(configAttributeMap.get(pattern));
            }
        }
        // 未设置操作请求权限，返回空集合
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
