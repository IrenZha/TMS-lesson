package com.example.lesson46_2.dto;

import lombok.Data;

@Data
public class UserDto {
    private String login;
    private String password;
    private Role role;
}
