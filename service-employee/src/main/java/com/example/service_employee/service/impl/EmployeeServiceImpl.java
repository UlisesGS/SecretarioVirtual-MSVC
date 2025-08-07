package com.example.service_employee.service.impl;

import com.example.service_employee.exceptions.ResourceNotFoundException;
import com.example.service_employee.mappers.EmployeeMapper;
import com.example.service_employee.model.Employee;
import com.example.service_employee.model.dtos.ResponseEmployeeDto;
import com.example.service_employee.repository.EmployeeRepository;
import com.example.service_employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<ResponseEmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();

        if (employeeList.isEmpty()){
            throw new ResourceNotFoundException("No hay datos guardados");
        }

        return employeeMapper.employeeListToResponseEmployeeDto(employeeList);
    }
}
