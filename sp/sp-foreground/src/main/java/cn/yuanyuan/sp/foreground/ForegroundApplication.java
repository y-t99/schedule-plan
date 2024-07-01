package cn.yuanyuan.sp.foreground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForegroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForegroundApplication.class, args);
        System.out.println(
                "SWAGGER : http://localhost:8088/swagger-ui.html"
        );
    }

}
