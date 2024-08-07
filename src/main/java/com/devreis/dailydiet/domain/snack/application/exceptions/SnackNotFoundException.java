package com.devreis.dailydiet.domain.snack.application.exceptions;

public class SnackNotFoundException extends RuntimeException {
    public SnackNotFoundException(String message) {
        super(message);
    }
}