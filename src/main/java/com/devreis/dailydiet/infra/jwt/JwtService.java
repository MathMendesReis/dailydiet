package com.devreis.dailydiet.infra.jwt;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.devreis.dailydiet.domain.user.enterprise.entity.UserModel;

@Service
public class JwtService {

    public String generateToken(UserModel user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getId().toString())
                    .withClaim("roles", user.getRole().toString())
                    .withExpiresAt(this.expiresIn())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public DecodedJWT validateToken(String token) {
        token = token.replace("Bearer ", "");

        Algorithm algorithm = Algorithm.HMAC256("secret");

        try {
            var tokenDecoded = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return tokenDecoded;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Instant expiresIn() {
        Instant expiresIn = Instant.now().plus(Duration.ofMinutes(30));
        return expiresIn;
    }

}
