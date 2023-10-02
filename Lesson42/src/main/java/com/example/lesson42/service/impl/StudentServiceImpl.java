package com.example.lesson42.service.impl;

import com.example.lesson42.domain.StudentDto;
import com.example.lesson42.mapper.StudentMapper;
import com.example.lesson42.model.StudentEntity;
import com.example.lesson42.repository.StudentRepository;
import com.example.lesson42.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Override
    public StudentDto getById(UUID id) {
        Optional<StudentEntity> studentOpt = repository.findById(id);
        StudentEntity studentEntity = studentOpt.orElseThrow(RuntimeException::new);
        return mapper.entityToStudentDto(studentEntity);
    }

    @Transactional
    @Override
    public void update(UUID id, String update) {
        StudentEntity studentEntity = repository.findById(id).orElseThrow(RuntimeException::new);
        Integer changeValue = studentEntity.getNumber();
        if (update.equals("up")) {
            List<StudentEntity> students = repository.findByNumberIsLessThan(studentEntity.getNumber());
            StudentEntity studentBefore = students
                    .stream()
                    .max(Comparator.comparingInt(StudentEntity::getNumber))
                    .orElseThrow(RuntimeException::new);
            System.out.println();
            studentEntity.saveNumber(studentBefore.getNumber());
            studentBefore.saveNumber(changeValue);
        }
        if (update.equals("down")) {
            List<StudentEntity> students = repository.findByNumberIsGreaterThan(studentEntity.getNumber());
            StudentEntity studentAfter = students
                    .stream()
                    .min(Comparator.comparingInt(StudentEntity::getNumber))
                    .orElseThrow(RuntimeException::new);

            studentEntity.saveNumber(studentAfter.getNumber());
            studentAfter.saveNumber(changeValue);
        }
    }

    @Override
    public List<StudentDto> order() {
        List<StudentEntity> byNumber = repository.findAllByOrderByNumber();
        return mapper.entityToStudentDto(byNumber);
    }
}
