package com.devreis.dailydiet.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.snack.application.usecases.CreateSnackUserCase;
import com.devreis.dailydiet.domain.snack.enterprise.dto.RequestSnackDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("snack")
public class CreateSnackController {

    @Autowired
    private CreateSnackUserCase createSnackController;
    @PostMapping()

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
