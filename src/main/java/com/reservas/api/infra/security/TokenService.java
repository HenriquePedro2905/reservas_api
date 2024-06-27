package com.reservas.api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.reservas.api.model.Usuarios.Usuarios;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;


    public String generateToken(Usuarios users){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("reservas-api")
                    .withSubject(users.getLogin())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
                return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("error", exception);
        }
    }

    public String validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm)
                .withIssuer("reservas-api")
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}