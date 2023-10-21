package com.example.lesson46_2.service.impl;

import com.example.lesson46_2.dto.UserDto;
import com.example.lesson46_2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final RestTemplate template;

    @Override
    public UserDto getById(UUID id) {
        return template.getForObject("http://127.0.0.1:8081/users/" + id, UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        UserDto[] object = template.getForObject("http://127.0.0.1:8081/users/", UserDto[].class);
        return Arrays.asList(object);
    }
}
