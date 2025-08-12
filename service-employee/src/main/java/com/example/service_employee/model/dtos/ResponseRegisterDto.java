package com.example.service_employee.model.dtos;

import com.example.service_employee.model.enums.Role;

import java.time.LocalDate;

public record ResponseRegisterDto(
        String id,
        String name,
        String surname,
        String email,
        String phone,
        String profession,
        LocalDate birthdate,
        Integer dni,
        Role role
) {}
