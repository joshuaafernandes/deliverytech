package com.deliverytech.delivery_api.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private String segredo;

    private Long expiracao; 


    private SecretKey getGerarChave(){
        return Keys.hmacShaKeyFor(segredo.getBytes(StandardCharsets.UTF_8));
    }

    public String gerarToken(String email){
        Date agora = new Date();
        Date validade = new Date(agora.getTime() + expiracao);

        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(agora)
            .setExpiration(validade)
            .signWith(getGerarChave())
            .compact();
    }

    public boolean isTokenValido(String token, UserDetails userDetails){
        final String email = getEmail(token);
        return email.equals(userDetails.getUsername());
    }

    public String getEmail(String token){
        return Jwts.parserBuilder()
            .setSigningKey(getGerarChave())
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }


}
