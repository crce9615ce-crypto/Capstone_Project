package com.core.CapstoneProject.ExceptionHandler;

public class UnauthorizedAccess extends RuntimeException {
    public UnauthorizedAccess(String message) {
        super(message);
    }
}
