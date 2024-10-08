package com.devreis.dailydiet.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.snack.application.usecases.UpdateSnackUseCase;
import com.devreis.dailydiet.domain.snack.enterprise.dto.RequestUpdateSnackDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("snack")
@Tag(name = "Snacks", description = "")

public class UpdateSnackController {

    @Autowired
    private UpdateSnackUseCase updateSnackUseCase;
    @PutMapping("/{snackId}")
     @Operation(summary = "Atualização de refeição", description = "Essa função é responsável por atualizar uma refeição")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = RequestUpdateSnackDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Usuário já existe")
    })
      @SecurityRequirement(name = "jwt_auth")

    public ResponseEntity<Object> handle(@PathVariable String snackId,
            @RequestBody RequestUpdateSnackDTO requestUpdateSnackDTO) {
        try {
            var res = updateSnackUseCase.execute(snackId, requestUpdateSnackDTO);
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
