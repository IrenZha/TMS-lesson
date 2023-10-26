package com.example.lesson46_2.client;

import com.example.lesson46_2.config.FeignConfig;
import com.example.lesson46_2.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "user-client", url = "${client.users}", configuration = FeignConfig.class)
public interface UserClient {
    @GetMapping
    List<UserDto> getAll();

    @GetMapping("/{id}")
    UserDto getById(@PathVariable(name = "id") UUID id);

    @PostMapping
    UserDto save(@RequestBody UserDto user);
}
