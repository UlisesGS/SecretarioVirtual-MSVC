package com.example.service_dailyAvailability.repository;

import com.example.service_dailyAvailability.model.DailyAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyAvailabilityRepository extends JpaRepository<DailyAvailability,String> {
}
