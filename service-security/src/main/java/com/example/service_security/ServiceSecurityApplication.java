package com.example.service_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.security.feign")
public class ServiceSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSecurityApplication.class, args);
	}

}
