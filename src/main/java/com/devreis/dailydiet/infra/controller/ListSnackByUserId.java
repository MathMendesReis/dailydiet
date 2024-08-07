package com.devreis.dailydiet.infra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.snack.application.usecases.ListSnacksByUserId;
import com.devreis.dailydiet.domain.user.enterprise.dto.UserLoginRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("snack")
@Tag(name = "Snacks", description = "")

public class ListSnackByUserId {

    @Autowired
    private ListSnacksByUserId listSnacksByUserId;
    
    @GetMapping()
     @Operation(summary = "Lista de refeições", description = "Essa função é responsável por listar todas as refeições do usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {}),
    })
      @SecurityRequirement(name = "jwt_auth")

    public ResponseEntity<Object> getMethodName(HttpServletRequest request) {
        var idUser = request.getAttribute("user_id");
        try {
            var response = this.listSnacksByUserId.execute(idUser.toString());
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
