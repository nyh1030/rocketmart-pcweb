package com.rocketmart.pcweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class RocketmartPcwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmartPcwebApplication.class, args);
    }
}
