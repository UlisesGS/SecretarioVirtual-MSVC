package com.example.service_employee.mappers;

import com.example.service_employee.model.Employee;
import com.example.service_employee.model.dtos.RequestRegisterEmployeeDto;
import com.example.service_employee.model.dtos.ResponseCredentialsDto;
import com.example.service_employee.model.dtos.ResponseEmployeeDto;
import com.example.service_employee.model.dtos.ResponseRegisterEmployeeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    List<ResponseEmployeeDto> employeeListToResponseEmployeeDto(List<Employee> employeeList);

    Employee registerDtoToEmployee(RequestRegisterEmployeeDto requestRegisterDto);
    ResponseRegisterEmployeeDto employeeToResponseRegister(Employee userEntity);

    //auth
    ResponseCredentialsDto employeeToResponseCredentialsDto(Employee employee);
}
