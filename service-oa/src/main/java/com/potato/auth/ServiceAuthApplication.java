package com.potato.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: ServiceAuthApplication
 * Package: com.potato.auth
 * Description:
 *
 * @Author: ZhouJF
 * @Create: 2023/4/3 - 10:16 PM
 */
@SpringBootApplication
@ComponentScan("com.potato")
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class,args);
    }
}
