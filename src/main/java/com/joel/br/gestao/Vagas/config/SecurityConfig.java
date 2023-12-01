package com.joel.br.gestao.Vagas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    private SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(e -> e.disable())
                .cors(e -> e.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/v1/candidate").permitAll()
                            .requestMatchers("/api/v1/company").authenticated()
                            .requestMatchers("/api/v1/jobs").authenticated();
                });


        return http.build();
    }
}
