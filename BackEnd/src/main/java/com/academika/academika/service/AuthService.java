package com.academika.academika.service;

import com.academika.academika.dto.login.LoginRequest;
import com.academika.academika.dto.login.LoginResponse;

public interface AuthService {
    LoginResponse authenticate(LoginRequest loginRequest);
}
