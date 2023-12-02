package com.joel.br.gestao.Vagas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(e -> e.disable())
                .cors(e -> e.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/v1/candidate").permitAll()
                            .requestMatchers("/h2-console/**").permitAll()
                            .requestMatchers("/auth/company").permitAll()
                            .requestMatchers("/api/v1/company").authenticated()
                            .requestMatchers("/api/v1/jobs").authenticated();
                });


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
