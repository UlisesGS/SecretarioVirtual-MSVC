package com.example.service_userEntity.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    String id;

    @NotBlank (message = "El username es obligatorio.")
    String username;
    @NotBlank(message = "El email es obligatorio.")
    @Email(message = "EL formato de email es invalido.")
    String email;
    @NotBlank(message = "El password es obligatorio.")
    String password;
    @Past(message = "Fecha invalida.")
    LocalDate birthdate;
    @NotNull(message = "El dni es obligatorio.")
    int dni;
}
