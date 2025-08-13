package com.example.service_employee.controller;

import com.example.service_employee.model.dtos.*;
import com.example.service_employee.service.EmployeeService;
import com.example.service_employee.service.ProvisionService;
import com.example.service_employee.utils.AllowedForEmployeesAndAdmins;
import com.example.service_employee.utils.AllowedForUsersAndEmployeesAndAdmins;
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
    private final ProvisionService provisionService;

    @AllowedForUsersAndEmployeesAndAdmins
    @GetMapping("/get-all")
    public ResponseEntity<List<ResponseEmployeeDto>> findAll(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @AllowedForEmployeesAndAdmins
    @PostMapping("/register")
    public ResponseEntity<ResponseRegisterEmployeeDto> create(@RequestBody @Valid RequestRegisterEmployeeDto user) {
        return new ResponseEntity<>(employeeService.create(user), HttpStatus.OK);
    }


}
