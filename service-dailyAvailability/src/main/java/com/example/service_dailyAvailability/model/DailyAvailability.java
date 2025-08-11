package com.example.service_dailyAvailability.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "dailys")
public class DailyAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String employeeId;
    private List<DateEntity> dateTime;

}
