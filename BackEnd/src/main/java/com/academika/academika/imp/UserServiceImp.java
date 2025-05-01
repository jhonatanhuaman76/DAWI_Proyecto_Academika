package com.academika.academika.imp;

import com.academika.academika.dto.user.UserRequestDTO;
import com.academika.academika.dto.user.UserResponseDTO;
import com.academika.academika.entity.Usuario;
import com.academika.academika.mapper.UserMapper;
import com.academika.academika.repository.UserRepository;
import com.academika.academika.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public UserResponseDTO registrar(UserRequestDTO requestDTO) {
        Usuario user = mapper.toEntity(requestDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDTO(repository.save(user));
    }




}
