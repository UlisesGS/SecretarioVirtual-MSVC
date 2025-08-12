package com.example.service_employee.model.dtos;

public record ResponseProvisionDto(
        String id,
        String employeeId,
        String name,
        Double price,
        boolean state
) {
}
