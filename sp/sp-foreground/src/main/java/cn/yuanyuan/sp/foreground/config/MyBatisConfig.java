package cn.yuanyuan.sp.foreground.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"cn.yuanyuan.sp.mbg.mapper", "cn.yuanyuan.sp.foreground.dao", })
public class MyBatisConfig {

}
