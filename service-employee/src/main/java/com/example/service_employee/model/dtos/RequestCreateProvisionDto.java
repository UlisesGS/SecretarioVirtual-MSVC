package com.example.service_employee.model.dtos;

public record RequestCreateProvisionDto(
        String emailEmployee,
        String name,
        Double price
) {
}
