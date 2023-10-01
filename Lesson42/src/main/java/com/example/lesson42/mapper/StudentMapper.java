package com.example.lesson42.mapper;

import com.example.lesson42.domain.StudentDto;
import com.example.lesson42.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "gender", source = "gender")
StudentEntity dtoToStudentEntity(StudentDto dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "gender", source = "gender")
    StudentDto entityToStudentDto(StudentEntity entity);

    List<StudentDto> entityToStudentDto(List<StudentEntity> entity);
}
