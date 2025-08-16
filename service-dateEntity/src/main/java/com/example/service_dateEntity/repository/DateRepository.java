package com.example.service_dateEntity.repository;

import com.example.service_dateEntity.model.DateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DateRepository extends JpaRepository<DateEntity, String> {
    List<DateEntity> findByDailyAvailabilityId_Id(String dailyId);

    @Query("SELECT d FROM DateEntity d " +
            "WHERE d.dailyAvailabilityId.id = :dailyId " +
            "AND DATE(d.startTime) = :date")
    List<DateEntity> findByDailyIdAndStartDate(
            @Param("dailyId") String dailyId,
            @Param("date") LocalDate date);
}

