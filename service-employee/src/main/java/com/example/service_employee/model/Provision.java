package com.example.service_employee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "provisions")
public class Provision {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String emailEmployee;
    private String name;
    private Double price;
    private boolean state;

    @PrePersist
    public void stateInit(){
        this.state=true;
    }
}
