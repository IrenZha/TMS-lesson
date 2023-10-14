package com.example.lesson46_1.web;

import com.example.lesson46_1.dto.UserDto;
import com.example.lesson46_1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @GetMapping
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto user) {
        return service.save(user);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable(name = "id") UUID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") UUID id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable(name = "id") UUID id, @RequestBody UserDto user) {
        return service.update(id, user);
    }

}
