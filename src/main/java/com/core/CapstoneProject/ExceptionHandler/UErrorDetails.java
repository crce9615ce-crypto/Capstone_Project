package com.core.CapstoneProject.ExceptionHandler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;
}
