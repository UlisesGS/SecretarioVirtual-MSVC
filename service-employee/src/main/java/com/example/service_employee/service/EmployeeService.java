package com.example.service_employee.service;

import com.example.service_employee.model.dtos.RequestRegisterEmployeeDto;
import com.example.service_employee.model.dtos.ResponseCredentialsDto;
import com.example.service_employee.model.dtos.ResponseEmployeeDto;
import com.example.service_employee.model.dtos.ResponseRegisterEmployeeDto;

import java.util.List;

public interface EmployeeService {

    ResponseCredentialsDto getCredentials(String email);

    List<ResponseEmployeeDto> getAllEmployees();

    ResponseRegisterEmployeeDto create(RequestRegisterEmployeeDto employee);

}
