package com.example.lesson46_2.web;

import com.example.lesson46_2.dto.UserDto;
import com.example.lesson46_2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/main")
public class MainController {
    private final UserService service;

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable(name = "id") UUID id)  {
        return service.getById(id);
    }
    @GetMapping
    public List<UserDto> getAll(){
      return service.getAll();
    }

    @PostMapping("/users")
    public UserDto save(@RequestBody UserDto user){
        return service.save(user);
    }
}
