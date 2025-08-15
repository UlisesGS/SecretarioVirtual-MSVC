package com.example.service_employee.service.impl;

import com.example.service_employee.exceptions.ResourceAlreadyExistsException;
import com.example.service_employee.exceptions.ResourceNotFoundException;
import com.example.service_employee.mappers.EmployeeMapper;
import com.example.service_employee.model.Employee;
import com.example.service_employee.model.dtos.RequestRegisterEmployeeDto;
import com.example.service_employee.model.dtos.ResponseCredentialsDto;
import com.example.service_employee.model.dtos.ResponseEmployeeDto;
import com.example.service_employee.model.dtos.ResponseRegisterEmployeeDto;
import com.example.service_employee.repository.EmployeeRepository;
import com.example.service_employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseCredentialsDto getCredentials(String email) {
        System.out.println(email);
        Employee userEntity = employeeRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Empleado con email: " + email + " no encontrado"
                ));
        System.out.println(userEntity);
        ResponseCredentialsDto credentialsDto=employeeMapper.employeeToResponseCredentialsDto(userEntity);
        System.out.println(credentialsDto);
        return credentialsDto;
    }

    @Override
    public List<ResponseEmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();

        if (employeeList.isEmpty()){
            throw new ResourceNotFoundException("No hay datos guardados");
        }

        return employeeMapper.employeeListToResponseEmployeeDto(employeeList);
    }

    @Override
    public ResponseRegisterEmployeeDto create(RequestRegisterEmployeeDto requestRegisterDto) {
        if (employeeRepository.findByEmail(requestRegisterDto.email()).isPresent()) {
            throw new ResourceAlreadyExistsException("Ya hay una cuenta asociada con el email " + requestRegisterDto.email() + ".");
        }

        if (employeeRepository.findByPhone(requestRegisterDto.phone()).isPresent()) {
            throw new ResourceAlreadyExistsException("Ya hay una cuenta asociada con el numero de celular " + requestRegisterDto.phone() + ".");
        }

        Employee employee = employeeMapper.registerDtoToEmployee(requestRegisterDto);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
        return employeeMapper.employeeToResponseRegister(employee);
    }
}
