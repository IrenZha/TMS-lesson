package com.example.lesson46_1.service.impl;

import com.example.lesson46_1.domain.UserEntity;
import com.example.lesson46_1.dto.UserDto;
import com.example.lesson46_1.exc.UserNotFoundException;
import com.example.lesson46_1.mapper.UserMapper;
import com.example.lesson46_1.repository.UserRepository;
import com.example.lesson46_1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> all = repository.findAll();
        return mapper.toDtos(all);
    }

    @Override
    public UserDto save(UserDto user) {
        UserEntity save = repository.save(mapper.toEntity(user));
        return mapper.toDto(save);
    }

    @Override
    public UserDto getById(UUID id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> {
            UserNotFoundException exc = new UserNotFoundException();
            exc.setErrorCode(100_001);
            exc.setMassage("User not found");
            return exc;
        }));
    }

    @Override
    public void delete(UUID id) {
        Optional<UserEntity> byId = repository.findById(id);
        if (byId.isPresent()) {
            repository.deleteById(id);
        }
    }

    @Transactional
    @Override
    public UserDto update(UUID id, UserDto user) {
        UserEntity toUpdate = repository.findById(id).orElseThrow(() -> {
            UserNotFoundException exc = new UserNotFoundException();
            exc.setErrorCode(100_002);
            exc.setMassage("User not found");
            return exc;
        });
        mapper.update(toUpdate, user);
        return mapper.toDto(toUpdate);
    }
}
