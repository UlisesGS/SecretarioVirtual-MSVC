package com.example.service_appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAppointmentApplication.class, args);
	}

}
