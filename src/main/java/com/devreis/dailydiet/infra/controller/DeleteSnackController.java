package com.devreis.dailydiet.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.snack.application.usecases.DeleteSnackUseCase;

@RestController
@RequestMapping("snack")
public class DeleteSnackController {
    @Autowired
    private DeleteSnackUseCase deleteSnackUseCase;
    @DeleteMapping("/{snackId}")
    public ResponseEntity<Object> handle(@PathVariable String snackId){
        try {
            this.deleteSnackUseCase.execute(snackId);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
