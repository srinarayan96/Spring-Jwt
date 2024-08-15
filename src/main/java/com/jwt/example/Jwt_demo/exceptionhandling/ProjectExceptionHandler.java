package com.jwt.example.Jwt_demo.exceptionhandling;
/*

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ProjectExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ AccessDeniedException.class, BadCredentialsException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Error handleAccessDenied(Exception ex, WebRequest request){
        return Error.builder()
                .message(ex.getMessage())
                .status("ACCESS DENIED")
                .timeStamp(new Date(System.currentTimeMillis()))
                .build();

    }
}
*/
