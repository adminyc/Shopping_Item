package com.wykl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//开启Feign支持
@EnableFeignClients
public class Feign80_application {
    public static void main(String[] args) {
        SpringApplication.run(Feign80_application.class,args);
    }
}
