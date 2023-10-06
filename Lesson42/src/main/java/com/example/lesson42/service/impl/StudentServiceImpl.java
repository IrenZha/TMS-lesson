package com.example.lesson42.service.impl;

import com.example.lesson42.domain.StudentDto;
import com.example.lesson42.domain.StudentSearchDto;
import com.example.lesson42.mapper.StudentMapper;
import com.example.lesson42.model.Gender;
import com.example.lesson42.model.StudentEntity;
import com.example.lesson42.repository.StudentRepository;
import com.example.lesson42.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

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

    @Override
    public List<StudentDto> search(StudentSearchDto searchDto) {
        List<StudentEntity> studentEntities;
        String text = searchDto.getText();
        if (isNoneBlank(text)) {
            studentEntities = repository.searchBy(text);
        } else {
            studentEntities = repository.findAll(createSearch(searchDto));
        }
        return mapper.entityToStudentDto(studentEntities);
    }

    private Specification<StudentEntity> createSearch(StudentSearchDto searchDto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            String firstName = searchDto.getFirstName();
            if (isNoneBlank(firstName)) {
                predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%"));
            }
            String lastName = searchDto.getLastName();
            if (isNoneBlank(lastName)) {
                predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%"));
            }
            if (searchDto.getAge() != null) {
                predicates.add(criteriaBuilder.equal(root.get("age"), searchDto.getAge()));
            }
            if (searchDto.getGender() != null) {
                predicates.add(criteriaBuilder.equal(root.get("gender"), searchDto.getGender()));
            }
            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }
}
