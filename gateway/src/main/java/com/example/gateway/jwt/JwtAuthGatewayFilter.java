package com.example.gateway.jwt;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthGatewayFilter implements GlobalFilter {

    private final JwtProvider jwtProvider;

    public JwtAuthGatewayFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().toString();
        System.out.println("Request Path: " + path);
        // Rutas públicas (no validar)
        if (path.startsWith("/auth/login") ||

                path.startsWith("/dates/create") || path.startsWith("/dates/list-all") ||

                path.startsWith("/employees/register") || path.startsWith("/employee/credentials/") ||

                path.startsWith("/availability/create") || path.startsWith("/availability/list-all") ||
                path.startsWith("/availability/list-dates-by-day") ||

                path.startsWith("/users/credentials/") || path.startsWith("/users/register") ||

                path.startsWith("/appointments/create") || path.startsWith("/appointments/list-all") ||

                path.startsWith("/provisions/create-provision") || path.startsWith("/provisions/list-all-provision") ||

                path.startsWith("/swagger") || path.startsWith("/v3/api-docs")) {

            return chain.filter(exchange);
        }

        String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        String token = authHeader.substring(7);

//        String token = null;
//        HttpCookie cookie = request.getCookies().getFirst("token");
//        System.out.println(cookie);
//        if (cookie != null) {
//            token = cookie.getValue();
//            System.out.println(token);
//        }
//
//        if (token == null) {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }

        System.out.println(token);
        if (!jwtProvider.isTokenValid(token)) {
            System.out.println("entro");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // Extraer info y pasarla como headers a los microservicios
        String email = jwtProvider.extractEmail(token);
        String role = jwtProvider.extractRole(token);

        ServerHttpRequest modifiedRequest = request.mutate()
                .header("X-User-Email", email)
                .header("X-User-Role", role)
                .build();
        System.out.println("final");
        return chain.filter(exchange.mutate().request(modifiedRequest).build());
    }

}
