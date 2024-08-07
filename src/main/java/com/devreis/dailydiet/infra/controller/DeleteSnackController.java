package com.devreis.dailydiet.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.snack.application.usecases.DeleteSnackUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("snack")
@Tag(name = "Snacks", description = "")

public class DeleteSnackController {
    @Autowired
    private DeleteSnackUseCase deleteSnackUseCase;

    @DeleteMapping("/{snackId}")
    @Operation(summary = "Deleção de refeição", description = "Essa função é responsável por deletar uma refeição")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
            }),
            @ApiResponse(responseCode = "400", description = "Refeição não encontrada")
    })
    @SecurityRequirement(name = "jwt_auth")
    public ResponseEntity<Object> handle(@PathVariable String snackId) {
        try {
            this.deleteSnackUseCase.execute(snackId);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
