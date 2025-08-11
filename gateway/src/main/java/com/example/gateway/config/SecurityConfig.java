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
                        .pathMatchers("/service-security/auth/login").permitAll()

                        .pathMatchers("/service-dateentity/dates/create-date",
                                "/service-dateentity/dates/list-all",
                                "/service-dateentity/availabilitys/create",
                                "/service-dateentity/availabilitys/list-all").permitAll()

                        .pathMatchers("/service-userentity/users/register",
                                "/service-userentity/users/credentials/*").permitAll()

                        .pathMatchers("/swagger/**", "/v3/api-docs/**").permitAll()
                        .anyExchange().authenticated()
                )
                .build();
    }
}