package com.example.lesson52.web;

import com.example.lesson52.dto.AuthResponse;
import com.example.lesson52.dto.UserDto;
import com.example.lesson52.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class userResource {
    private final UserService service;

    @PostMapping("reg")
    public ResponseEntity<UserDto> create(@RequestBody UserDto request) {
        UserDto saved = service.save(request);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("auth")
    public ResponseEntity<AuthResponse> auth(@RequestBody UserDto request) {
        var saved = service.auth(request);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("private")
    public ResponseEntity<Void> privatePage() {
        return ResponseEntity.ok().build();
    }
}
