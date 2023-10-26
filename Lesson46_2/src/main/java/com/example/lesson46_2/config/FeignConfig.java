package com.example.lesson46_2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class FeignConfig {
    private final ObjectMapper mapper;

    @Bean
    ErrorDecoder errorDecoder() {
        return new UserErrorDecoder(mapper);
    }
}
