package com.example.service_userEntity.model;


import com.example.service_userEntity.model.enums.Role;
import com.example.service_userEntity.model.enums.UserState;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String surname;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(name = "birth_date")
    private LocalDate birthdate;

    @Column(unique = true)
    private Integer dni;

    @Enumerated(EnumType.STRING)
    private UserState state;

    @Enumerated(EnumType.STRING)
    private Role role;

    @PrePersist
    private void preStateAndRol(){
        this.state=UserState.DESACTIVADO;
        this.role=Role.USER;
    }

}
