package com.example.lesson46_1.web;

import com.example.lesson46_1.exc.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestController {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserNotFoundException> handleUserNotfound(UserNotFoundException exc) {
        return ResponseEntity.status(404).body(exc);
    }
}
