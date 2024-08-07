package com.devreis.dailydiet.infra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devreis.dailydiet.domain.snack.application.usecases.ListSnacksByUserId;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("snack")
public class ListSnackByUserId {

    @Autowired
    private ListSnacksByUserId listSnacksByUserId;
    
    @GetMapping()
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
