package com.devreis.dailydiet.domain.user.enterprise.dto;

import com.devreis.dailydiet.domain.user.enterprise.entity.UserRole;

public record CreateUserRequestDTO(
        String email,
        String password,
        UserRole role
        ) {

}
