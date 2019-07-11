package com.wykl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eureka6001_application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka6001_application.class,args);
    }
}
