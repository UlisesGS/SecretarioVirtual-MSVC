package com.example.service_employee.repository;

import com.example.service_employee.model.Provision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvisionRepository extends JpaRepository<Provision,String> {
}
