package com.example.service_employee.validations;

import com.example.service_employee.exceptions.ResourceNotFoundException;
import com.example.service_employee.model.Employee;
import com.example.service_employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Validations {
        private final EmployeeRepository employeeRepository;

        public boolean getAuthenticatedUser(String email){
            String employeeEmail = SecurityContextHolder.getContext().getAuthentication().getName();

            employeeRepository.findByEmail(employeeEmail)
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

            return employeeEmail.equals(email);
        }
}
