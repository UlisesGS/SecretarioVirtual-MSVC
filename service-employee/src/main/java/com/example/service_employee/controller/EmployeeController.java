package com.example.service_employee.controller;

import com.example.service_employee.model.dtos.RequestRegisterDto;
import com.example.service_employee.model.dtos.ResponseEmployeeDto;
import com.example.service_employee.model.dtos.ResponseRegisterDto;
import com.example.service_employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
    @GetMapping("/get-all")
    public ResponseEntity<List<ResponseEmployeeDto>> findAll(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<ResponseRegisterDto> create(@RequestBody @Valid RequestRegisterDto user) {
        return new ResponseEntity<>(employeeService.create(user), HttpStatus.OK);
    }
}
