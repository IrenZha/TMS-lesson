package com.example.lesson52.service.impl;

import com.example.lesson52.domain.UserEntity;
import com.example.lesson52.dto.AuthResponse;
import com.example.lesson52.dto.UserDto;
import com.example.lesson52.mapper.UserMapper;
import com.example.lesson52.repository.UserRepository;
import com.example.lesson52.service.TokenService;
import com.example.lesson52.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final TokenService tokenService;
    private final UserRepository repository;
    private final UserMapper mapper;

    @Transactional
    @Override
    public UserDto save(UserDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public AuthResponse auth(UserDto request) {
        Optional<UserEntity> optionalUser = repository.findByUsername(request.getUsername());
        UserEntity user = optionalUser.orElseThrow(RuntimeException::new);
        String token = tokenService.createToken(user);
        return new AuthResponse(token);
    }
}
