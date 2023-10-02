package com.example.lesson42.domain;

import com.example.lesson42.model.Gender;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

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

    public StudentDto(UUID id, String name, Integer age, Gender gender, Integer number) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
