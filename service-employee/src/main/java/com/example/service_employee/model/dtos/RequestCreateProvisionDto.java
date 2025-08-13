package com.example.service_employee.model.dtos;

public record RequestCreateProvisionDto(
        String employeeId,
        String name,
        Double price
) {
}
