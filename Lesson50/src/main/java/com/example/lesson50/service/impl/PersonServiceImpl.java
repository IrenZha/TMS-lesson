package com.example.lesson50.service.impl;

import com.example.lesson50.domain.Permission;
import com.example.lesson50.domain.Person;
import com.example.lesson50.dto.PermissionDto;
import com.example.lesson50.dto.PersonDto;
import com.example.lesson50.mapper.PermissionMapper;
import com.example.lesson50.mapper.PersonMapper;
import com.example.lesson50.repository.PersonRepository;
import com.example.lesson50.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final PersonMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final PermissionMapper permissionMapper;

    @Transactional
    @Override
    public PersonDto save(PersonDto dto) {
        String permissions = dto.getPermissions();
        String[] split = permissions.split(",");
        List<PermissionDto> permissionDtos = Arrays.stream(split)
                .map(PermissionDto::new)
                .peek(permission -> permission.setPersonDtos(List.of(dto)))
                .collect(Collectors.toList());

        Person person = mapper.toEntity(dto);
        person.setPermissions(permissionMapper.toEntities(permissionDtos));
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        return mapper.toDto(repository.save(person));
    }
}
