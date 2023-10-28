package com.example.lesson50.mapper;

import com.example.lesson50.domain.Permission;
import com.example.lesson50.dto.PermissionDto;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PermissionMapper {

    Permission toEntity(PermissionDto dto);
    List<Permission> toEntities(List<PermissionDto> dtos);

}
