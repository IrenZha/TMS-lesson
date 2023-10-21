package com.example.lesson46_2.service.impl;

import com.example.lesson46_2.client.UserClient;
import com.example.lesson46_2.dto.UserDto;
import com.example.lesson46_2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserClient client;

    @Override
    public UserDto getById(UUID id) {
        return client.getById(id);
    }

    @Override
    public List<UserDto> getAll() {
        return client.getAll();
    }

    @Override
    public UserDto save(UserDto user) {
        return client.save(user);
    }
}
