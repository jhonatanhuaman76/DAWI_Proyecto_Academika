package com.academika.academika.dto.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserRequestDTO {
    private String nombre;
    private LocalDate fechaNac;
    private String email;
    private String password;
    private String rol;
}
