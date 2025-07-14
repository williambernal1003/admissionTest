package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.infrastructure.Config.JwtUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtUtils jwtUtils;

    public AuthService(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public String login(String username, String password) {
        if (username.equals("admin") && password.equals("1234")) {
            return jwtUtils.generateToken(username);
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}