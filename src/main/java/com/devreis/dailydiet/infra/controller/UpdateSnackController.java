package com.devreis.dailydiet.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.snack.application.usecases.UpdateSnackUseCase;
import com.devreis.dailydiet.domain.snack.enterprise.dto.RequestUpdateSnackDTO;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("snack")
public class UpdateSnackController {

    @Autowired
    private UpdateSnackUseCase updateSnackUseCase;
    @PutMapping("/{snackId}")
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
