package com.example.lesson50.mapper;

import com.example.lesson50.domain.Person;
import com.example.lesson50.dto.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = PermissionMapper.class)
public interface PersonMapper {
    @Mapping(target = "permissions", ignore = true)
    Person toEntity(PersonDto dto);
    List<Person> toEntities(List<PersonDto> dtos);
    @Mapping(target = "permissions", ignore = true)
    PersonDto toDto(Person person);
    List<PersonDto> toDtos(List<Person> persons);
}
