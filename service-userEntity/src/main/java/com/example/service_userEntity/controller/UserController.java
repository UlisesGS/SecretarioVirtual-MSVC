package com.example.service_userEntity.controller;

import com.example.service_userEntity.model.dtos.*;
import com.example.service_userEntity.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody @Valid RequestLoginDto loginRequest) {
//        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
//    }

    @GetMapping("/credentials/{email}")
    public ResponseEntity<ResponseCredentialsDto> getCredentials(@PathVariable String email) {
        System.out.println("entro 1");
        return new ResponseEntity<>(userService.getCredentials(email), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseRegisterDto> create(@RequestBody @Valid RequestRegisterDto user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ResponseUserDto>> getAll() {
        return new ResponseEntity<>(userService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/getById/{userId}")
    public ResponseEntity<ResponseUserDto> getUserById(@PathVariable String userId) {
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }
}
