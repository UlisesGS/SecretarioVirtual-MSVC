package com.example.service_dailyAvailability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceDailyAvailabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDailyAvailabilityApplication.class, args);
	}

}
