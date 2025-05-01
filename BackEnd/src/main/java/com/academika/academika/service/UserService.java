package com.academika.academika.service;

import com.academika.academika.dto.user.UserRequestDTO;
import com.academika.academika.dto.user.UserResponseDTO;
import com.academika.academika.entity.TipoRolUser;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> listar();
    UserResponseDTO registrar(UserRequestDTO requestDTO);
    UserResponseDTO buscarPorRol(Long id, TipoRolUser rol);
    UserResponseDTO buscarPorInstructor(Long id);
}
