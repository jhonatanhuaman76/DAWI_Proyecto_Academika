package com.academika.academika.dto.login;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    //private String nombre;
    private String email;
    private String password;

}
