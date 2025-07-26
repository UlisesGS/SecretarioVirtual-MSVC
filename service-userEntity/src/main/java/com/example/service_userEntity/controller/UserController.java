package com.example.service_userEntity.controller;

import com.example.service_userEntity.model.UserEntity;
import com.example.service_userEntity.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getById/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?>createUser(@RequestBody @Valid UserEntity newUser){
        return new ResponseEntity<>(userService.createUser(newUser), HttpStatus.CREATED);
    }
}
