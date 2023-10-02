package com.example.lesson42.domain;

import com.example.lesson42.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.rmi.server.UID;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class StudentDto {
    private UUID id;
    @NotBlank
    @NotNull
    private String name;
    @Max(100)
    @Min(5)
    private Integer age;
    private Gender gender;
}
