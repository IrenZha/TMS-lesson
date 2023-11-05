package com.example.lesson52.service;

import com.example.lesson52.dto.AuthResponse;
import com.example.lesson52.dto.UserDto;

public interface UserService {
    UserDto save(UserDto dto);

    AuthResponse auth(UserDto request);

}
