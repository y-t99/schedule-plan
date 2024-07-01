package cn.yuanyuan.sp.background.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"cn.yuanyuan.sp.mbg.mapper", "cn.yuanyuan.sp.background.dao"})
public class MybatisConfig {
}
