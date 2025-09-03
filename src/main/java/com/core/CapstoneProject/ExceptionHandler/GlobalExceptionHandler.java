package com.core.CapstoneProject.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UnauthorizedAccess.class)
    public ResponseEntity<UErrorDetails> unauthorizedAccess(UnauthorizedAccess ua, WebRequest http){

        UErrorDetails err = new UErrorDetails();
        err.setMessage(ua.getMessage());
        err.setTimestamp(LocalDateTime.now());
        err.setDetails(http.getDescription(false));
        return new ResponseEntity<UErrorDetails>(err, HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(InvalidUsername.class)
    public ResponseEntity<UErrorDetails> unauthorizedAccess(InvalidUsername iu, WebRequest http){

        UErrorDetails err = new UErrorDetails();
        err.setMessage(iu.getMessage());
        err.setTimestamp(LocalDateTime.now());
        err.setDetails(http.getDescription(false));
        return new ResponseEntity<UErrorDetails>(err, HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(ServiceUnreachable.class)
    public ResponseEntity<UErrorDetails> serviceUnavailable(ServiceUnreachable iu, WebRequest http){

        UErrorDetails err = new UErrorDetails();
        err.setMessage(iu.getMessage());
        err.setTimestamp(LocalDateTime.now());
        err.setDetails(http.getDescription(false));
        return new ResponseEntity<UErrorDetails>(err, HttpStatus.SERVICE_UNAVAILABLE);

    }

    @ExceptionHandler(InputError.class)
    public ResponseEntity<UErrorDetails> inputError(InputError iu, WebRequest http){

        UErrorDetails err = new UErrorDetails();
        err.setMessage(iu.getMessage());
        err.setTimestamp(LocalDateTime.now());
        err.setDetails(http.getDescription(false));
        return new ResponseEntity<UErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }

}
