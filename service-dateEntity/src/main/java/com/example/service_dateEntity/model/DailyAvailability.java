package com.example.service_dateEntity.model;

import com.example.service_dateEntity.model.enums.DaysOfTheWeek;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    @Enumerated(EnumType.STRING)
    private DaysOfTheWeek dayOfTheWeek;

    @OneToMany(mappedBy = "dailyAvailabilityId")
    private List<DateEntity> dateList;

    @PrePersist
    private void initDateList(){
        this.dateList=new ArrayList<>();
    }
}
