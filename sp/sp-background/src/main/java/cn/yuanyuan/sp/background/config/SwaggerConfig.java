package cn.yuanyuan.sp.background.config;

import cn.yuanyuan.sp.common.config.BaseSwaggerConfig;
import cn.yuanyuan.sp.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by macro on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("cn.yuanyuan.sp.background.controller")
                .title("sp后台系统")
                .description("sp后台相关接口文档")
                .contactName("yuanyuan")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
}
