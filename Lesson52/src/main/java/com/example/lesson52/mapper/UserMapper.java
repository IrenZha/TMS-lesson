package com.example.lesson52.mapper;

import com.example.lesson52.domain.UserEntity;
import com.example.lesson52.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(UserDto dto);
    @Mapping(target = "password", ignore = true)
    UserDto toDto(UserEntity entity);
}
