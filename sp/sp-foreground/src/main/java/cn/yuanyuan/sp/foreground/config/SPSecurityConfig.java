package cn.yuanyuan.sp.foreground.config;

import cn.yuanyuan.sp.foreground.service.UmsUserService;
import cn.yuanyuan.sp.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SPSecurityConfig extends SecurityConfig {

    @Autowired
    UmsUserService userService;

    @Bean
    public UserDetailsService userDetailsService() {
        return userService::loadUserByUsername;
    }


}
