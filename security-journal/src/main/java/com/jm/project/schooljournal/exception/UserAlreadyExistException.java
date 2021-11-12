package com.jm.project.schooljournal.exception;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String username) {
        super("User with name=" + username + " already exists");
    }
}
