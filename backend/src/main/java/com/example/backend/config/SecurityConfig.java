package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig {
    private final CorsFilter corsFilter;

    public SecurityConfig(
        CorsFilter corsFilter
    ) {
        this.corsFilter = corsFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // cors configuration
            .addFilterBefore(
                corsFilter,
                UsernamePasswordAuthenticationFilter.class
            )

            // csrf configuration
            .csrf(AbstractHttpConfigurer::disable)

            .authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                .requestMatchers("/api/signup").permitAll()
                    .anyRequest().authenticated()
            );

        return http.build();
    }
}
