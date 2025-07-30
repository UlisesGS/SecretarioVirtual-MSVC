package com.example.service_security.jwt;

import com.example.service_security.exception.ExpiredJwtException;
import com.example.service_security.exception.JwtException;
import com.example.service_security.exception.MalformedJwtException;
import com.example.service_security.exception.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        try {
            String jwt = getJwtFromRequest(request);

            // Si no hay token, seguimos con la cadena de filtros
            if (jwt == null) {
                filterChain.doFilter(request, response);
                return;
            }

            // Extraemos email del token
            String userEmail = jwtService.extractEmail(jwt);

            // Solo autenticar si no hay otro usuario ya autenticado
            if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

                // Verificamos la validez del token
                if (jwtService.isTokenValid(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }

            // Continuar con la cadena de filtros
            filterChain.doFilter(request, response);

        } catch (ExpiredJwtException ex) {
            handlerExceptionResolver.resolveException(request, response, null, ex);
        } catch (SignatureException | MalformedJwtException ex) {
            handlerExceptionResolver.resolveException(request, response, null, ex);
        } catch (JwtException ex) {
            handlerExceptionResolver.resolveException(request, response, null, ex);
        } catch (Exception ex) {
            handlerExceptionResolver.resolveException(request, response, null, ex);
        }
    }

    // Extrae el token del header
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}

