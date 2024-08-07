package com.devreis.dailydiet.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.snack.application.usecases.CreateSnackUserCase;
import com.devreis.dailydiet.domain.snack.enterprise.dto.RequestSnackDTO;
import com.devreis.dailydiet.domain.user.enterprise.dto.UserLoginRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("snack")
@Tag(name = "Snacks", description = "")

public class CreateSnackController {

    @Autowired
    private CreateSnackUserCase createSnackController;

    @PostMapping()
    @Operation(summary = "Cadastro de refeição", description = "Essa função é responsável por cadastrar uma refeição")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = RequestSnackDTO.class))
            }),
    })
    @SecurityRequirement(name = "jwt_auth")
    public ResponseEntity<Object> handle(HttpServletRequest request, @RequestBody RequestSnackDTO body) {
        var idUser = request.getAttribute("user_id");

        try {
            var response = this.createSnackController.execute(idUser.toString(), body);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
