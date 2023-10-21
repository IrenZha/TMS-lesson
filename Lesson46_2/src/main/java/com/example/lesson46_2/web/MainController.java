package com.example.lesson46_2.web;

import com.example.lesson46_2.dto.ErrorResponse;
import com.example.lesson46_2.dto.UserDto;
import com.example.lesson46_2.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@OpenAPIDefinition(info = @Info(
        title = "IL layer",
        description = "This is a sample server",
        version = "1.0.1"
))
@RequiredArgsConstructor
@RestController
@RequestMapping("/main")
public class MainController {
    private final UserService service;

    @Operation(description = "Description",
            summary = "Getting a user by id",
            tags = "users",
            responses = {
                    @ApiResponse(description = "successful operation", responseCode = "200"),
                    @ApiResponse(description = "User not found", responseCode = "404", content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    ))
            })
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable(name = "id") UUID id) {
        return service.getById(id);
    }

    @Operation(description = "Description",
            summary = "Getting a list of all users",
            tags = "users",
            responses = {
                    @ApiResponse(description = "successful operation",
                            responseCode = "200", content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class))
                    ))
            })
    @GetMapping
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @PostMapping("/users")
    public UserDto save(@RequestBody UserDto user) {
        return service.save(user);
    }
}
