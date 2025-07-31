package com.example.service_userEntity.model;


import com.example.service_userEntity.model.enums.Role;
import com.example.service_userEntity.model.enums.UserState;
import jakarta.persistence.*;
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

    private String username;
    private String email;
    private String password;
    private LocalDate birthdate;
    int dni;
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
