package com.devreis.dailydiet.domain.user.enterprise.dto;

import java.time.Instant;

public class UserLoginResponseDTO {
    private String access_token;
    private Instant expires_in;

    public UserLoginResponseDTO(String access_token,Instant expires_in){
        this.access_token = access_token;
        this.expires_in= expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Instant getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Instant expires_in) {
        this.expires_in = expires_in;
    }
    
} 
