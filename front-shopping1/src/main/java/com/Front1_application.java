package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@ServletComponentScan("com.wykl.listener")  //扫描监听器
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.wykl.dao")
public class Front1_application {
    public static void main(String[] args) {
        SpringApplication.run(Front1_application.class,args);
    }
}
