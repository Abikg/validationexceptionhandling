package com.example.validationexceptionhandling.execptionshandler;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
