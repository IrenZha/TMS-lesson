package com.example.lesson46_1.exc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserNotFoundException extends RuntimeException{
    private Integer errorCode;
    private String massage;
}
