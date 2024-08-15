package com.jwt.example.Jwt_demo.controllers;

import com.jwt.example.Jwt_demo.models.Token;
import com.jwt.example.Jwt_demo.services.JwtManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.jwt.example.Jwt_demo.services.JwtManager.JWT_TOKEN_VALIDITY;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AccessController {
    private final JwtManager jwtManager;
    @GetMapping("/access-token")
    public Token getToken(){
        String token = jwtManager.generateJwtToken();
        return Token.builder()
                .token(token)
                .issuedAt(new Date(System.currentTimeMillis()))
                .validTill(new Date(System.currentTimeMillis() +JWT_TOKEN_VALIDITY))
                .build();
    }
}
