package com.example.lesson42.service;

import com.example.lesson42.domain.StudentDto;
import com.example.lesson42.domain.StudentSearchDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    void save(StudentDto dto);

    List<StudentDto> getAll();

    StudentDto getById(UUID id);

    void update(UUID id, String update);

    List<StudentDto> order();
    List<StudentDto> search(StudentSearchDto searchDto);

}
