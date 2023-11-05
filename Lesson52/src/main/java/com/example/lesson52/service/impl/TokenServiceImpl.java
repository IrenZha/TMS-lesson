package com.example.lesson52.service.impl;

import com.example.lesson52.domain.UserEntity;
import com.example.lesson52.service.TokenService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {
    @Value("${app.token.secret}")
    private String secret;
    private Key key;

    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    @Override
    public String createToken(UserEntity user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("login", user.getUsername())
                .claim("role", user.getRole())
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

    }

    @Override
    public Authentication fromToken(String token) {
        try {
            String rowToken = getRowToken(token);
            Jwt<Header, Claims> claimsJwt = Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJwt(rowToken);
            Claims payload = claimsJwt.getPayload();
            String username = (String) payload.get("login");
            String role = (String) payload.get("role");
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
            List<SimpleGrantedAuthority> authorities = List.of(simpleGrantedAuthority);
            return new UsernamePasswordAuthenticationToken(username, null, authorities);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private String getRowToken(String full) {
        return full.substring(full.indexOf(" ")).strip();
    }
}
