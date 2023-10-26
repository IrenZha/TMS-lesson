package com.example.lesson46_2.mapper;

import com.example.lesson46_2.dto.ErrorResponse;
import com.example.lesson46_2.exc.UserNotFoundException;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ErrorMapper {
    ErrorResponse toDto(UserNotFoundException exc);
}
