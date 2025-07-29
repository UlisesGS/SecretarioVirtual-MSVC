package com.example.service_security.service;

import com.example.service_security.dto.RequestLoginDto;
import com.example.service_security.dto.ResponseLoginDto;
import com.example.service_security.dto.ResponseUserEntityDto;
import com.example.service_security.feign.UserEntityClient;
import com.example.service_security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserEntityClient userClient;
    private final JwtProvider jwtProvider;

    public ResponseLoginDto login(RequestLoginDto request) {
        // 1. Llamar al microservicio de usuarios
        ResponseUserEntityDto user = userClient.validateUser(request);

        // 2. Generar token JWT
        String accessToken = jwtProvider.generateToken(user.getEmail(), user.getRole());
        String refreshToken = jwtProvider.generateRefreshToken(user.getEmail());

        return new ResponseLoginDto(accessToken, refreshToken);
    }
}
