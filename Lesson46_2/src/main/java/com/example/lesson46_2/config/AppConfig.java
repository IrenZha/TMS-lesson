package com.example.lesson46_2.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableFeignClients(basePackages = "com.example.lesson46_2.client")
public class AppConfig {

//    @Bean
//    RestTemplate template(){
//        return new RestTemplate();
//    }
}
