package com.example.service_userEntity.controller;

import com.example.service_userEntity.model.dtos.UserEntityDto;
import com.example.service_userEntity.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid UserEntityDto user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userService.listAll(), HttpStatus.OK);
    }

}
