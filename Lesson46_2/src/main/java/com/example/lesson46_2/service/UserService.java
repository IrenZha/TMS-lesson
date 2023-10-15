package com.example.lesson46_2.service;

import com.example.lesson46_2.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto getById(UUID id);

    List<UserDto> getAll();

    UserDto save(UserDto user);
}
