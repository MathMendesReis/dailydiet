package com.devreis.dailydiet.infra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.user.application.usecases.AuthUserUseCase;
import com.devreis.dailydiet.domain.user.enterprise.dto.UserLoginRequestDTO;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("user")
public class AuthenticateUserController {

    @Autowired
    private AuthUserUseCase authUserUseCase;

    @PostMapping("/auth")
     public ResponseEntity<Object> handle(@RequestBody @Valid UserLoginRequestDTO body) {
        try {
            var response = authUserUseCase.execute(body);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
}
