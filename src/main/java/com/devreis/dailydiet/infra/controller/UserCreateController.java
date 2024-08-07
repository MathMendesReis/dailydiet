package com.devreis.dailydiet.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.user.application.usecases.CreateUserUseCase;
import com.devreis.dailydiet.domain.user.enterprise.dto.CreateUserRequestDTO;
import com.devreis.dailydiet.domain.user.enterprise.dto.UserLoginRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("user")
@Tag(name = "User", description = "Registro de usúario")

public class UserCreateController {

    @Autowired
    private CreateUserUseCase createUserUseCase;
    @PostMapping()
     @Operation(summary = "Registro de usuario", description = "Essa função é responsável por salvar um usuario.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = CreateUserRequestDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Usuário já existe")
    })
      @SecurityRequirement(name = "jwt_auth")

    public ResponseEntity<Object> handle(@RequestBody @Valid CreateUserRequestDTO body) {
        try {
            var response = createUserUseCase.execute(body);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
