package com.core.CapstoneProject.ExceptionHandler;

public class ServiceUnreachable extends RuntimeException {
    public ServiceUnreachable(String message) {
        super(message);
    }
}
