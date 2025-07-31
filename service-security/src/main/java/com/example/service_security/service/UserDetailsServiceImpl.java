package com.example.service_security.service;

import com.example.service_security.dto.RequestLoginDto;
import com.example.service_security.dto.ResponseLoginDto;
import com.example.service_security.dto.ResponseUserEntityDto;
import com.example.service_security.exception.InvalidUserCredentialsException;
import com.example.service_security.feign.UserEntityClient;
import com.example.service_security.jwt.JwtProvider;
import com.example.service_security.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserEntityClient userClient; // tu FeignClient que consulta al microservicio user-entity

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder; // BCrypt

    public ResponseLoginDto login(RequestLoginDto request) {

        UserDetails userDetails = loadUserByUsername(request.email());


        // Verificar password con BCrypt
//        if (!passwordEncoder.matches(request.password(), userDetails.getPassword())) {
        System.out.println(request.password());
        System.out.println(userDetails.getPassword());
        if (!request.password().equals(userDetails.getPassword())) {
            throw new InvalidUserCredentialsException("Usuario o contraseña inválidos");
        }

        // Generar tokens JWT (Access + Refresh)
        String accessToken = jwtProvider.generateToken(
                Map.of("role", userDetails.getAuthorities()), // agregamos el rol en claims
                userDetails.getUsername()
        );

        String refreshToken = jwtProvider.generateRefreshToken(userDetails.getUsername());

        // Devolver DTO con ambos tokens
        return new ResponseLoginDto(accessToken, refreshToken);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ResponseUserEntityDto user = userClient.getByEmail(email); // creamos este endpoint en user-entity
        System.out.println(user.getEmail());
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con email: " + email);
        }
        List<String> userRole = new ArrayList<>();
        System.out.println(user.getRole());

        userRole.add(user.getRole().toString());


        if (userRole.isEmpty()){
            throw new InvalidUserCredentialsException("Error en el sistema.");
        }

        Collection<? extends GrantedAuthority> authorities = userRole.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toSet());


        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword()) // no se usa para login, pero Spring lo necesita en el objeto
                .authorities(authorities)  // o convertir a GrantedAuthorities si hay varios roles
                .build();

    }
}
