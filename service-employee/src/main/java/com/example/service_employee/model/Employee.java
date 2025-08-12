package com.example.service_employee.model;


import com.example.service_employee.model.enums.EmployeeState;
import com.example.service_employee.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String surname;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private String password;

    private String profession;

    @Column(name = "birth_date")
    private LocalDate birthdate;

    @Column(unique = true)
    private Integer dni;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private EmployeeState state;

    @PrePersist
    private void preStateAndRol(){
        this.state=EmployeeState.DESACTIVADO;
        this.role=Role.EMPLOYEE;
    }
}
