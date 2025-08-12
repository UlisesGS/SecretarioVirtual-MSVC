package com.example.service_appointment.controller;

import com.example.service_appointment.model.dtos.RequestCreateAppointmentDto;
import com.example.service_appointment.model.dtos.ResponseAppointmentDto;
import com.example.service_appointment.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/create")
    public ResponseEntity<ResponseAppointmentDto>create(@RequestBody@Valid RequestCreateAppointmentDto appointmentDto){
        return new ResponseEntity<>(appointmentService.createAppointment(appointmentDto), HttpStatus.OK);
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<ResponseAppointmentDto>>getAll(){
        return new ResponseEntity<>(appointmentService.getAll(),HttpStatus.OK);
    }

}
