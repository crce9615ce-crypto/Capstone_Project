package com.core.CapstoneProject.ExceptionHandler;

public class InvalidUsername extends RuntimeException {
    public InvalidUsername(String message) {
        super(message);
    }
}
