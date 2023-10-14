package com.example.lesson46_2.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String login;
    private String password;
    private Role role;
}
