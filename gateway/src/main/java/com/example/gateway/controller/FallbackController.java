package com.example.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FallbackController {

    @RequestMapping("/fallback/userentity")
    public ResponseEntity<Map<String, String>> userFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("error", "El servicio de usuarios no está disponible actualmente.");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }

    @RequestMapping("/fallback/security")
    public ResponseEntity<Map<String, String>> securityFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("error", "El servicio de seguridad no está disponible actualmente.");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }

    @RequestMapping("/fallback/dateentity")
    public ResponseEntity<Map<String, String>> dateFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("error", "El servicio de Fechas no está disponible actualmente.");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }

    @RequestMapping("/fallback/employee")
    public ResponseEntity<Map<String, String>> employeeFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("error", "El servicio de empleados no está disponible actualmente.");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }
}
