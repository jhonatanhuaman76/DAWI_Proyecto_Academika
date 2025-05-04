package com.academika.academika.security;

import com.academika.academika.entity.TipoRolUser;
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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailService userDetailService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // Públicos
                        .requestMatchers("/auth/login", "/auth/registrar", "/curso/listar/masrecientes", "/categoria/listar-con-cursos").permitAll() //NO HAY PROBLEMAS

                        // ADMIN e INSTRUCTOR pueden acceder al resto de /curso/**
                        .requestMatchers("/curso/main/**").hasAnyRole("ADMIN", "INSTRUCTOR") // NO DEJA CON ADMIN NI INSTRUCTOR

                        // /curso/listar accesible por todos los roles
                        .requestMatchers("/curso/student/listar").hasRole("ESTUDIANTE") //NO HAY PROBLEMAS





                        // matricula/guardar y matricula/estudiante para ESTUDIANTE y ADMIN
                        .requestMatchers("/matricula/estudiante/**").hasAnyRole("ADMIN", "ESTUDIANTE") //NO HAY PROBLEMAS
                        .requestMatchers("/matricula/guardar").hasAnyRole("ADMIN", "ESTUDIANTE") //NO DEJA CON ESTUDIANTE NI ADMIN

                        // /curso/listar accesible por todos los roles
                        .requestMatchers("/curso/listar").hasAnyRole("ADMIN", "INSTRUCTOR", "ESTUDIANTE") //NO HAY PROBLEMAS



                        // ADMIN puede acceder a todo lo siguiente
                        .requestMatchers("/user/**", "/matricula/**", "/categoria/**").hasRole("ADMIN") //FUNCIONA CATEGORIA
                        // HAY PROBLEMAS RELACIONADOS CON LOS CAMPOS ANTERIORES

                        // Todo lo demás requiere autenticación
                        .anyRequest().authenticated()
                )
                .authenticationProvider(provider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }*/


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // Públicos
                        .requestMatchers("/auth/login", "/auth/registrar", "/curso/listar/masrecientes", "/categoria/listar-con-cursos", "/curso/buscar/**").permitAll()

                        // ESTUDIANTE
                        .requestMatchers("/matricula/estudiante/**", "/matricula/guardar").hasAnyAuthority(TipoRolUser.ESTUDIANTE.toString())

                        // INSTRUCTOR
                        .requestMatchers("/curso/guardar", "/curso/instructor/**", "/curso/borrar/**", "/categoria/listar").hasAnyAuthority(TipoRolUser.INSTRUCTOR.toString())

                        // ADMIN
                        .requestMatchers("/user/**", "/matricula/**", "/categoria/**", "/curso/**", "/auth/**").hasAnyAuthority(TipoRolUser.ADMIN.toString())
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
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200")); // o "*"
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
