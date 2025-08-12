package com.example.service_employee.service;

import com.example.service_employee.model.dtos.RequestRegisterDto;
import com.example.service_employee.model.dtos.ResponseEmployeeDto;
import com.example.service_employee.model.dtos.ResponseRegisterDto;

import java.util.List;

public interface EmployeeService {

    List<ResponseEmployeeDto> getAllEmployees();

    ResponseRegisterDto create(RequestRegisterDto employee);
}
