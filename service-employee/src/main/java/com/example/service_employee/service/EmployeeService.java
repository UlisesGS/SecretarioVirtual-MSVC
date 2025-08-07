package com.example.service_employee.service;

import com.example.service_employee.model.dtos.ResponseEmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<ResponseEmployeeDto> getAllEmployees();
}
