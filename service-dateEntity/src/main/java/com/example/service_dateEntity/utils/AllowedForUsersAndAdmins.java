package com.example.service_dateEntity.utils;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE}) // Puede usarse en métodos y clases
@Retention(RetentionPolicy.RUNTIME)
@Documented
@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
public @interface AllowedForUsersAndAdmins {
}
