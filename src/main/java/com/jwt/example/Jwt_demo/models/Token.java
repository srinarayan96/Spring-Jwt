package com.jwt.example.Jwt_demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Token {
    private String token;
    private Date issuedAt;
    private Date validTill;
}
