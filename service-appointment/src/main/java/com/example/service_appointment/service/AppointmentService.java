package com.example.service_appointment.service;

import com.example.service_appointment.model.dtos.RequestCreateAppointmentDto;
import com.example.service_appointment.model.dtos.ResponseAppointmentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {
    ResponseAppointmentDto createAppointment(RequestCreateAppointmentDto appointmentDto);
    List<ResponseAppointmentDto>getAll();
}
