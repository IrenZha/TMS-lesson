package com.example.lesson46_1.service;

import com.example.lesson46_1.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDto> getAll();

    UserDto save(UserDto user);

    UserDto getById(UUID id);

    void delete(UUID id);

    UserDto update(UUID id, UserDto user);
}
