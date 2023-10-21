package com.example.lesson46_1.dto;

import com.example.lesson46_1.domain.Role;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String login;
    private String password;
    private Role role;
}
