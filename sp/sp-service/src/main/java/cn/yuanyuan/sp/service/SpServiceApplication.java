package cn.yuanyuan.sp.service;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class SpServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpServiceApplication.class, args);
    }

}
