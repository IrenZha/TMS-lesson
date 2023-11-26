package com.example.lesson52.dto;

import com.example.lesson52.domain.Role;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;

    private Role role;
}

