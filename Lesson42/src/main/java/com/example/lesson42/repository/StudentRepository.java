package com.example.lesson42.repository;

import com.example.lesson42.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaSpecificationExecutor<StudentEntity>, JpaRepository<StudentEntity, UUID> {
    List<StudentEntity> findAllByOrderByNumber();

    List<StudentEntity> findByNumberIsGreaterThan(Integer number);

    List<StudentEntity> findByNumberIsLessThan(Integer number);

    @Query(value = "from StudentEntity where " +
            "upper(firstName) like upper(concat('%',:text, '%')) " +
            "or upper(lastName) like  upper(concat('%',:text, '%')) " +
            "or gender = upper(:text)" +
            "or cast(age as string) = :text")
    List<StudentEntity> searchBy(@Param("text") String text);
}
