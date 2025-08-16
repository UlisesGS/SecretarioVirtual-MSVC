package com.example.service_security.controller;

import com.example.service_security.dto.RequestLoginDto;
import com.example.service_security.dto.RequestRefreshDto;
import com.example.service_security.dto.ResponseLoginDto;
import com.example.service_security.service.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
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
    public ResponseEntity<ResponseLoginDto> login(@RequestBody @Valid RequestLoginDto request, HttpServletResponse response) {
        return new ResponseEntity<>(authService.login(request, response), HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<ResponseLoginDto> refresh(HttpServletRequest request) {
        return new ResponseEntity<>(authService.refresh(request), HttpStatus.OK);
    }
}
