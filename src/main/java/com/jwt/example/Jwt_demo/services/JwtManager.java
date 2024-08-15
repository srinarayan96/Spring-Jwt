package com.jwt.example.Jwt_demo.services;

import com.jwt.example.Jwt_demo.utils.JwtConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtManager {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60*1000;


    public String generateJwtToken(){
        SecretKey secretKey = Keys.hmacShaKeyFor(JwtConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var roles =authentication.getAuthorities();
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles.stream().map(GrantedAuthority::getAuthority).reduce("",
                (s, grantedAuthority) -> s+","+grantedAuthority));
        return Jwts.builder().setClaims(claims).setSubject(authentication.getName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(secretKey).compact();
    }
}
