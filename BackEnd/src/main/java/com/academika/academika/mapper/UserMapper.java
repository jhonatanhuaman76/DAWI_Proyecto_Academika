package com.academika.academika.mapper;

import com.academika.academika.dto.user.UserRequestDTO;
import com.academika.academika.dto.user.UserResponseDTO;
import com.academika.academika.entity.TipoRolUser;
import com.academika.academika.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDTO toDTO(User user){
        return UserResponseDTO.builder()
                .id(user.getId())
                .nombre(user.getNombre())
                .fechaNac(user.getFechaNac())
                .email(user.getEmail())
                .rol(user.getRol().toString())
                .build();
    }

    public User toEntity(UserRequestDTO requestDTO){
        return User.builder()
                .nombre(requestDTO.getNombre())
                .fechaNac(requestDTO.getFechaNac())
                .email(requestDTO.getEmail())
                .password(requestDTO.getPassword())
                .rol(TipoRolUser.valueOf(requestDTO.getRol()))
                .build();
    }
}
