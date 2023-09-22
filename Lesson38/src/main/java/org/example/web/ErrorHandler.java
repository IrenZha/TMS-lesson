package org.example.web;

import org.example.exception.BookExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(BookExistsException.class)
    public String errorBook(){
        return "error";
    }
}
