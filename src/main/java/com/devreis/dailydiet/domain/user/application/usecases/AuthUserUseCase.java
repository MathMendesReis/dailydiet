package com.devreis.dailydiet.domain.user.application.usecases;



import java.time.Duration;
import java.time.Instant;

import javax.security.sasl.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.devreis.dailydiet.domain.user.enterprise.dto.UserLoginRequestDTO;
import com.devreis.dailydiet.domain.user.enterprise.dto.UserLoginResponseDTO;
import com.devreis.dailydiet.domain.user.enterprise.exceptions.UserExistsException;
import com.devreis.dailydiet.infra.database.UserRepository;
import com.devreis.dailydiet.infra.jwt.JwtService;

@Service
public class AuthUserUseCase {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private JwtService jwtService;


    public AuthUserUseCase( UserRepository userRepository,PasswordEncoder passwordEncoder,JwtService jwtService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
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

        var token = this.jwtService.generateToken(user);
        var expiresIn = Instant.now().plus(Duration.ofMinutes(10));
        
        return new UserLoginResponseDTO(token, expiresIn) ;
    }
}
