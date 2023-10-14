package com.example.lesson42.domain;

import com.example.lesson42.model.Gender;
import lombok.Data;

@Data
public class StudentSearchDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
    private String text;
}
