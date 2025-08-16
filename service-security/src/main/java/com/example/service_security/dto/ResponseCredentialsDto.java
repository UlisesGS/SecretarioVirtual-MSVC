package com.example.service_security.dto;

import com.example.service_security.model.Role;


public class ResponseCredentialsDto {

    private String id;
    private String email;
    private String name;
    private String surname;
    private Role role;
    private String password;

    public ResponseCredentialsDto() {
    }

    public ResponseCredentialsDto(String id, String email, String surname, String name, Role role, String password) {
        this.id = id;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
