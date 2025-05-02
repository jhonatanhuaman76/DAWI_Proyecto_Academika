package com.academika.academika.security;

import com.academika.academika.security.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailService userDetailService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // Públicos
                        .requestMatchers("/auth/login", "/auth/registrar", "curso/listar/masrecientes", "categoria/listar-con-cursos").permitAll()

                        // matricula/guardar y matricula/estudiante para ESTUDIANTE y ADMIN
                        .requestMatchers("/matricula/estudiante/**").hasAnyRole("ADMIN", "ESTUDIANTE")

                        // matricula/guardar y matricula/estudiante para ESTUDIANTE y ADMIN
                        .requestMatchers("/matricula/guardar").hasAnyRole("ADMIN", "ESTUDIANTE")

                        // /curso/listar accesible por todos los roles
                        .requestMatchers("/curso/listar").hasAnyRole("ADMIN", "INSTRUCTOR", "ESTUDIANTE")

                        // ADMIN e INSTRUCTOR pueden acceder al resto de /curso/**
                        .requestMatchers("/curso/**").hasAnyRole("ADMIN", "INSTRUCTOR")

                        // ADMIN puede acceder a todo lo siguiente
                        .requestMatchers("/user/**", "/matricula/**", "/categoria/**").hasRole("ADMIN")

                        // Todo lo demás requiere autenticación
                        .anyRequest().authenticated()
                )
                .authenticationProvider(provider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider provider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
