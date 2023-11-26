package com.example.lesson50.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class PersonDto {
    private UUID id;
    private String username;
    private String password;
    private String permissions;

}
