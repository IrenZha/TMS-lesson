package com.example.lesson46_1.mapper;

import com.example.lesson46_1.domain.UserEntity;
import com.example.lesson46_1.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {
    UserDto toDto(UserEntity userEntity);

    List<UserDto> toDtos(List<UserEntity> userEntity);

    UserEntity toEntity(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget UserEntity toUpdate, UserDto user);
}
