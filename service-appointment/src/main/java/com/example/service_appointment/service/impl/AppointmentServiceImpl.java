package com.example.service_appointment.service.impl;

import com.example.service_appointment.mappers.AppointmentMapper;
import com.example.service_appointment.model.Appointment;
import com.example.service_appointment.model.dtos.RequestCreateAppointmentDto;
import com.example.service_appointment.model.dtos.ResponseAppointmentDto;
import com.example.service_appointment.model.enums.AppointmentState;
import com.example.service_appointment.repository.AppointmentRepository;
import com.example.service_appointment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public ResponseAppointmentDto createAppointment(RequestCreateAppointmentDto appointmentDto) {
        Appointment appointment=appointmentMapper.requestTooAppointment(appointmentDto);
        appointment.setState(AppointmentState.RESERVADO);
        appointment=appointmentRepository.save(appointment);
        return appointmentMapper.appointmentToAppointmentDto(appointment);
    }

    @Override
    public List<ResponseAppointmentDto> getAll() {
        return appointmentMapper.appointmentListToAppointmentDtoList(appointmentRepository.findAll());
    }
}
