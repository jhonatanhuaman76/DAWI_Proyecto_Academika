package com.academika.academika.dto.login;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String token;
    private String nombre;
    private String email;
    private String rol;
    private long expirateAt;
}
