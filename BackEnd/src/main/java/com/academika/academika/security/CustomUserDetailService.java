package com.academika.academika.security;

import com.academika.academika.entity.Usuario;
import com.academika.academika.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService{

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no registrado"));

        return new User(
                user.getEmail(),                       // el username ahora es el email
                user.getPassword(),
                Collections.singletonList(
                        new SimpleGrantedAuthority("ROLE_" + user.getRol().name())
                )
        );
    }
}
