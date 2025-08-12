package com.example.service_appointment.model;

import com.example.service_appointment.model.enums.AppointmentState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private AppointmentState state;
    private String userId;
    private String dateId;
    private String serviceId;

}
