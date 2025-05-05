package com.academika.academika.infra.errores;

import com.academika.academika.infra.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, String>> duplicate(CustomException e) {
        return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Map<String, String>> notFound(UsernameNotFoundException e) {
        return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
    }
}
