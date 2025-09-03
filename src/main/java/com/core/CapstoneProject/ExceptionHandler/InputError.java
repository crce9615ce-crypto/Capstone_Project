package com.core.CapstoneProject.ExceptionHandler;

public class InputError extends RuntimeException {
    public InputError(String message) {
        super(message);
    }
}
