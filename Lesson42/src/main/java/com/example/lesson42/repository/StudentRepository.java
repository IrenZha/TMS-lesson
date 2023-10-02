package com.example.lesson42.repository;

import com.example.lesson42.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
    List<StudentEntity> findAllByOrderByNumber();
    List<StudentEntity> findByNumberIsGreaterThan(Integer number);
    List<StudentEntity> findByNumberIsLessThan(Integer number);
}
