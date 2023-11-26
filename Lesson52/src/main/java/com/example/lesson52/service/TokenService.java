package com.example.lesson52.service;

import com.example.lesson52.domain.UserEntity;
import org.springframework.security.core.Authentication;

public interface TokenService {
    String createToken(UserEntity user);
    Authentication fromToken(String token);
}
