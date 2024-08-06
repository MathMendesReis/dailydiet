package com.devreis.dailydiet.domain.user.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.Instant;

import javax.security.sasl.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.devreis.dailydiet.domain.user.enterprise.dto.UserLoginRequestDTO;
import com.devreis.dailydiet.domain.user.enterprise.dto.UserLoginResponseDTO;
import com.devreis.dailydiet.domain.user.enterprise.exceptions.UserExistsException;
import com.devreis.dailydiet.infra.database.UserRepository;

@Service
public class AuthUserUseCase {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;


    public AuthUserUseCase( UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserLoginResponseDTO execute(UserLoginRequestDTO userLoginRequestDTO) throws AuthenticationException {

        var user = this.userRepository.findByEmail(userLoginRequestDTO.email()).orElseThrow(() -> {
            throw new UserExistsException();
        });

        var passwordMatches = this.passwordEncoder
                .matches(userLoginRequestDTO.password(), user.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256("teste");
        Instant expiresIn = Instant.now().plus(Duration.ofMinutes(10));
        var token = JWT.create()
                .withIssuer("javagas")
                .withSubject(user.getId().toString())
                .withExpiresAt(expiresIn)
                .sign(algorithm);
        
        return new UserLoginResponseDTO(token, expiresIn) ;
    }
}
