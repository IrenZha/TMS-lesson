package com.example.lesson46_2.web;

import com.example.lesson46_2.dto.ErrorResponse;
import com.example.lesson46_2.exc.UserNotFoundException;
import com.example.lesson46_2.mapper.ErrorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionRestController {
    private final ErrorMapper mapper;

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotfound(UserNotFoundException exc) {
        return ResponseEntity.status(404).body(mapper.toDto(exc));
    }
}
