package com.example.service_appointment.mappers;

import com.example.service_appointment.model.Appointment;
import com.example.service_appointment.model.dtos.RequestCreateAppointmentDto;
import com.example.service_appointment.model.dtos.ResponseAppointmentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    ResponseAppointmentDto appointmentToAppointmentDto(Appointment appointment);
    Appointment requestTooAppointment(RequestCreateAppointmentDto appointmentDto);
    List<ResponseAppointmentDto> appointmentListToAppointmentDtoList(List<Appointment> appointmentList);

}
