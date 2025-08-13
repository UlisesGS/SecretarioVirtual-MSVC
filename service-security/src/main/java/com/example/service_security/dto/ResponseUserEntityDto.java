package com.example.service_security.dto;

import com.example.service_security.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserEntityDto {
    private String id;
    private String email;
    private String name;
    private String surname;
    private Role role;
    private String password;

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
