package com.example.service_employee.controller;

import com.example.service_employee.model.dtos.ResponseEmployeeDto;
import com.example.service_employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/get-all")
    public ResponseEntity<List<ResponseEmployeeDto>> findAll(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }
}
