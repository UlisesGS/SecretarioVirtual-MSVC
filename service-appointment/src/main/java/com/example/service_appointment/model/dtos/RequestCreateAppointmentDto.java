package com.example.service_appointment.model.dtos;

import com.example.service_appointment.model.enums.AppointmentState;

public record RequestCreateAppointmentDto(
        String userId,
        String dateId,
        String serviceId
) {
}
