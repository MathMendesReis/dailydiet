package com.devreis.dailydiet.domain.user.enterprise.dto;

public record UserLoginRequestDTO(
    String email,
    String password
) {
    
}
