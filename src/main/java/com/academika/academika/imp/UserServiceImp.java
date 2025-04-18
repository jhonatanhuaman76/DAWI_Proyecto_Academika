package com.academika.academika.imp;

import com.academika.academika.dto.UserRequestDTO;
import com.academika.academika.dto.UserResponseDTO;
import com.academika.academika.mapper.UserMapper;
import com.academika.academika.repository.UserRepository;
import com.academika.academika.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public UserResponseDTO registrar(UserRequestDTO requestDTO) {
        return mapper.toDTO(repository.save(mapper.toEntity(requestDTO)));
    }
}
