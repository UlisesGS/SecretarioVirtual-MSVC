package com.example.service_employee.mappers;

import com.example.service_employee.model.Employee;
import com.example.service_employee.model.dtos.RequestRegisterDto;
import com.example.service_employee.model.dtos.ResponseEmployeeDto;
import com.example.service_employee.model.dtos.ResponseRegisterDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    List<ResponseEmployeeDto> employeeListToResponseEmployeeDto(List<Employee> employeeList);

    Employee registerDtoToEmployee(RequestRegisterDto requestRegisterDto);
    ResponseRegisterDto employeeToResponseRegister(Employee userEntity);
}
