package com.example.service_dateEntity.repository;


import com.example.service_dateEntity.model.DailyAvailability;
import com.example.service_dateEntity.model.DateEntity;
import com.example.service_dateEntity.model.enums.DaysOfTheWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyAvailabilityRepository extends JpaRepository<DailyAvailability,String> {
    @Query("SELECT d FROM DateEntity d " +
            "WHERE d.dailyAvailabilityId.dayOfTheWeek = :dayOfTheWeek " +
            "AND d.dailyAvailabilityId.employeeId = :employeeId")
    List<DateEntity> findAllByDayAndEmployee(@Param("dayOfTheWeek") DaysOfTheWeek dayOfTheWeek,
                                             @Param("employeeId") String employeeId);
}
