package com.example.lesson46_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.lesson46_2.client")
@SpringBootApplication
public class Lesson462Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson462Application.class, args);
    }

}
