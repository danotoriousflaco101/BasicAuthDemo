package com.flaco.basicauthdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Definisci encoder (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Dice a Spring "Usa mio servizio per trovare utenti"
    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder encoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService); // il mio servizio
        provider.setPasswordEncoder(encoder); // encoder BCrypt
        return provider;
    }

    // Security filter (regole x ruoli)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Off per semplicità (non in prod!)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/**").hasRole("ADMIN") // solo ADMIN
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") // USER o ADMIN
                .requestMatchers("/").permitAll() // tutti possono accedere alla home "pubblica"
                .anyRequest().authenticated() // non in produzione
            )
            .httpBasic(Customizer.withDefaults()); // Basic Auth (utente+pwd in header) per demo

        return http.build();
    }
}