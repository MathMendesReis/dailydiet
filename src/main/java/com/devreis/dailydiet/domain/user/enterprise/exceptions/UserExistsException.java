package com.devreis.dailydiet.domain.user.enterprise.exceptions;

public class UserExistsException extends RuntimeException{
    public UserExistsException(){
        super("User already exists");
    }
}
