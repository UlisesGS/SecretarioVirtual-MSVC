package com.example.service_userEntity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.stream.Collectors;

@Configuration
public class KeyConfig {

    @Value("${jwt.public-key}")
    private Resource publicKeyResource;

    @Bean
    public PublicKey publicKey() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(publicKeyResource.getInputStream()))) {
            String publicKeyPEM = br.lines()
                    .filter(line -> !line.contains("BEGIN") && !line.contains("END"))
                    .collect(Collectors.joining());

            byte[] decoded = Base64.getDecoder().decode(publicKeyPEM);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
            return KeyFactory.getInstance("RSA").generatePublic(keySpec);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo cargar la clave pública", e);
        }
    }
}
