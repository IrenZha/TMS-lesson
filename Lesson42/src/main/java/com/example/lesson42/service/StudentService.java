package com.example.lesson42.service;

import com.example.lesson42.domain.StudentDto;

import java.util.List;

public interface StudentService {
    void save(StudentDto dto);
    List<StudentDto> getAll();
}
