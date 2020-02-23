package com.rocketmart.pcweb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class RocketmartPcwebApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RocketmartPcwebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
