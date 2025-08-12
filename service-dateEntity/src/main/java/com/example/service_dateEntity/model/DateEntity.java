package com.example.service_dateEntity.model;

import com.example.service_dateEntity.model.enums.DateState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "dates")
public class DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Integer duration;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private DateState state;

    private boolean fixed;

    @ManyToOne
    @JoinColumn(name="daily_id")
    private DailyAvailability dailyAvailabilityId;
}
