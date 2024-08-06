package com.devreis.dailydiet.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.user.application.usecases.CreateUserUseCase;
import com.devreis.dailydiet.domain.user.enterprise.dto.CreateUserRequestDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("user")
public class UserCreateController {

    @Autowired
    private CreateUserUseCase createUserUseCase;
    @PostMapping()
    public ResponseEntity<Object> handle(@RequestBody @Valid CreateUserRequestDTO body) {
        try {
            var response = createUserUseCase.execute(body);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
