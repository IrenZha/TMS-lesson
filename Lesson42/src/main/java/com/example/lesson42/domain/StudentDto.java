package com.example.lesson42.domain;

import com.example.lesson42.model.Gender;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;
@Data
public class StudentDto {
    private UUID id;
    @NotBlank
    @NotNull
    private String name;
    @Max(100)
    @Min(5)
    private Integer age;
    private Gender gender;
    private Integer number;

}
