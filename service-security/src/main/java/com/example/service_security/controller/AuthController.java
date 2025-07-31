package com.example.service_security.controller;

import com.example.service_security.dto.RequestLoginDto;
import com.example.service_security.dto.ResponseLoginDto;
import com.example.service_security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsServiceImpl authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDto> login(@RequestBody RequestLoginDto request) {
        System.out.println("ENTRÓ AL ENDPOINT DE LOGIN");
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }

    @PostMapping("/auth/refresh")
    public ResponseLoginDto refresh(@RequestBody RequestRefreshDto request) {
        // Validar refresh token
        // Generar nuevo access token
        // Devolverlo al front
    }
}
