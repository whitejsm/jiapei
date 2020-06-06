package com.woniu.jiapei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.woniu.jiapei.mapper")
@EnableScheduling
public class JiapeiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiapeiApplication.class, args);
    }

}
