package com.example.lesson46_2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Schema(title = "UserDto request")
public class UserDto {
    private UUID id;
    @Schema(title = "set uniq login")
    @NotNull
    private String login;
    @NotNull@Size(min = 5)
    private String password;
    private Role role;
}
