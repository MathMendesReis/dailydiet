package com.devreis.dailydiet.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.user.application.usecases.CreateUserUseCase;
import com.devreis.dailydiet.domain.user.enterprise.dto.CreateUserRequestDTO;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("user")
public class UserCreateController {

    @Autowired
    private CreateUserUseCase createUserUseCase;
    @PostMapping()
    public ResponseEntity<Object> handle() {
        try {
            var teste = new CreateUserRequestDTO("example@email.com", "123456");
            var response = createUserUseCase.execute(teste);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
