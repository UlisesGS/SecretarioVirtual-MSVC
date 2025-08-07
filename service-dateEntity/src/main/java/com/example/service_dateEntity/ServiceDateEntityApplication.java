package com.example.service_dateEntity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceDateEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDateEntityApplication.class, args);
	}

}
