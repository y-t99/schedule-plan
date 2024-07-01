package cn.yuanyuan.sp.background;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackgroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackgroundApplication.class, args);
        System.out.println(
                "\n\n\n" +
                "    SWAGGER : http://localhost:8087/swagger-ui.html" +
                "\n\n\n"
        );
    }

}
