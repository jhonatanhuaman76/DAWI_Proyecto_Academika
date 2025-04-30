package com.academika.academika.service;

import com.academika.academika.dto.user.UserRequestDTO;
import com.academika.academika.dto.user.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> listar();
    UserResponseDTO registrar(UserRequestDTO requestDTO);
    //Métodos adicionales
    UserResponseDTO obtenerPorId(Long id);
    void eliminar(Long id);
    UserResponseDTO actualizar(Long id, UserRequestDTO requestDTO);

}
