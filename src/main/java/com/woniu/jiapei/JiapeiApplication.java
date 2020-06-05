package com.woniu.jiapei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JiapeiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiapeiApplication.class, args);
    }

}
