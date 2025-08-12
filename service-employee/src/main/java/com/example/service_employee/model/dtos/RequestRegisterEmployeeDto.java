package com.example.service_employee.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record RequestRegisterEmployeeDto(
        @NotBlank(message = "El nombre es obligatorio.")
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El nombre solo debe contener letras.")
        String name,

        @NotBlank(message = "El apellido es obligatorio.")
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El apellido solo debe contener letras.")
        String surname,

        @NotBlank(message = "El email es obligatorio.")
        @Email(message = "Formato de email no válido.")
        String email,

        @NotNull(message = "El teléfono es obligatorio.")
        @Pattern(regexp = "^[0-9]+$", message = "El teléfono solo debe contener números.")
        String phone,

        @NotBlank(message = "La profesion es obligatorio.")
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El apellido solo debe contener letras.")
        String profession,

        @NotBlank(message = "El password es obligatorio.")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]).{8,}$",
                message = "La contraseña debe tener al menos 8 caracteres, una letra mayúscula, una letra minúscula, un número y un carácter especial (!@#$%^&*()).")
        String password,

        @NotNull(message = "La fecha de nacimiento es obligatoria.")
        @JsonFormat(pattern="yyyy-MM-dd")
        @Past(message = "La fecha de nacimiento debe estar en el pasado.")
        LocalDate birthdate,

        @NotNull(message = "El dni es obligatorio.")
        Integer dni
) {
}
