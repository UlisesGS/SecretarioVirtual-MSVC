package com.example.service_security.service;

import com.example.service_security.dto.RequestLoginDto;
import com.example.service_security.dto.ResponseLoginDto;
import com.example.service_security.dto.ResponseUserEntityDto;
import com.example.service_security.exception.InvalidUserCredentialsException;
import com.example.service_security.feign.UserEntityClient;
import com.example.service_security.jwt.JwtProvider;
import com.example.service_security.model.Role;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserEntityClient userClient; // tu FeignClient que consulta al microservicio user-entity

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder; // BCrypt

    public ResponseLoginDto login(RequestLoginDto request, HttpServletResponse response) {

        UserDetails userDetails = loadUserByUsername(request.email());


         //Verificar password con BCrypt
        if (!passwordEncoder.matches(request.password(), userDetails.getPassword())) {
            throw new InvalidUserCredentialsException("Usuario o contraseña inválidos");
        }


        // Generar tokens JWT (Access + Refresh)
//        String accessToken = jwtProvider.generateToken(
//                Map.of("role", userDetails.getAuthorities(), "type", "ACCESS"), // agregamos el rol en claims
//                userDetails.getUsername()
//        );
        String role = userDetails.getAuthorities().iterator().next().getAuthority();

        String accessToken = jwtProvider.generateToken(
                Map.of("role", role, "type", "ACCESS"),
                userDetails.getUsername()
        );


        String refreshToken = jwtProvider.generateRefreshToken(
                Map.of("role", role,"type", "REFRESH"),
                userDetails.getUsername()
        );

        // Configurar cookie JWT
        Cookie jwtCookie = new Cookie("token", refreshToken);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setSecure(false); // Cambiar a true en producción con HTTPS
        jwtCookie.setPath("/auth/refresh");
        jwtCookie.setMaxAge(60 * 60); // 1 hora

        response.addCookie(jwtCookie);

        // Limpiar cualquier cookie de sesión anterior que pueda causar conflictos
        Cookie sessionCookie = new Cookie("JSESSIONID", "");
        sessionCookie.setPath("/");
        sessionCookie.setMaxAge(0);
        response.addCookie(sessionCookie);

        // Devolver DTO con ambos tokens
        return new ResponseLoginDto(accessToken, refreshToken);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("entro");
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


    public ResponseLoginDto refresh(HttpServletRequest request) {

        // Buscar el refresh token en las cookies
        String refreshToken = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("token".equals(cookie.getName())) {
                    refreshToken = cookie.getValue();
                    break;
                }
            }
        }

        if (refreshToken == null) {
            throw new InvalidUserCredentialsException("No se encontró el refresh token en la cookie");
        }

        // Validar que sea un JWT válido y que sea un refresh token
        if (!jwtProvider.isTokenValid(refreshToken) || !jwtProvider.isRefreshToken(refreshToken)) {
            throw new InvalidUserCredentialsException("Refresh token inválido");
        }

        // Extraer el email del usuario
        String email = jwtProvider.extractEmail(refreshToken);
        //Extrae el role
        String role = jwtProvider.extractRole(refreshToken);


        // Generar nuevo access token (NO generamos nuevo refresh token aquí, solo access)
        String newAccessToken = jwtProvider.generateToken(Map.of("role", role, "type", "ACCESS"), email);

        // Devolver el nuevo access token
        return new ResponseLoginDto(newAccessToken, refreshToken);
    }
}
