package com.example.service_dateEntity.repository;

import com.example.service_dateEntity.model.DateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DateRepository extends JpaRepository<DateEntity, String> {
    List<DateEntity> findByDailyAvailabilityId_Id(String dailyId);
}
