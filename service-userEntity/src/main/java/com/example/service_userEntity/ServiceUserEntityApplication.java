package com.example.service_userEntity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceUserEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceUserEntityApplication.class, args);
	}

}
