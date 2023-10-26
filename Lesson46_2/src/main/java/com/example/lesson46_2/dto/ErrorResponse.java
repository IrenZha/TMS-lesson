package com.example.lesson46_2.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    private Integer errorCode;
    private String massage;
}
