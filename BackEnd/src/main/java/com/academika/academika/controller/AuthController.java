package com.academika.academika.controller;

import com.academika.academika.dto.login.LoginRequest;
import com.academika.academika.dto.login.LoginResponse;
import com.academika.academika.dto.user.UserRequestDTO;
import com.academika.academika.dto.user.UserResponseDTO;
import com.academika.academika.imp.UserServiceImp;
import com.academika.academika.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserServiceImp imp;
    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest);
        LoginResponse response = service.authenticate(loginRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/registrar")
    public UserResponseDTO registrar(@RequestBody UserRequestDTO requestDTO) {
        return imp.registrar(requestDTO);
    }

}
