package com.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/auth/login").permitAll()
                        .pathMatchers("/dates/create-date",
                                "/dates/list-all").permitAll()
                        .pathMatchers("/dates/create",
                                "/dates/list-all").permitAll()
                        .pathMatchers("/employees/get-all").permitAll()
                        .pathMatchers("/users/register",
                                "/users/credentials/*").permitAll()
                        .pathMatchers("/appointments/create",
                                "/appointments/list-all").permitAll()
                        .pathMatchers("/employees/create-provision",
                                "/employees/list-all-provision").permitAll()
                        .pathMatchers("/swagger/**", "/v3/api-docs/**").permitAll()
                        .anyExchange().authenticated()
                )
                .build();
    }
}