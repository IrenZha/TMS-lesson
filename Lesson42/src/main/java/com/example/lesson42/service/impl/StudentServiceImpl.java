package com.example.lesson42.service.impl;

import com.example.lesson42.domain.StudentDto;
import com.example.lesson42.mapper.StudentMapper;
import com.example.lesson42.model.StudentEntity;
import com.example.lesson42.repository.StudentRepository;
import com.example.lesson42.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper mapper;
    private final StudentRepository repository;

    @Override
    public void save(StudentDto dto) {
        StudentEntity entity = mapper.dtoToStudentEntity(dto);
        repository.save(entity);
    }

    @Override
    public List<StudentDto> getAll() {
        var allStudents = repository.findAll();
        return mapper.entityToStudentDto(allStudents);
    }
}
