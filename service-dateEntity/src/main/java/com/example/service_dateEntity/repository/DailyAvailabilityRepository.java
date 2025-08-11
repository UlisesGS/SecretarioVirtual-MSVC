package com.example.service_dateEntity.repository;


import com.example.service_dateEntity.model.DailyAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyAvailabilityRepository extends JpaRepository<DailyAvailability,String> {
}
