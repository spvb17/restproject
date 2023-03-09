package com.example.backendfinalproject.exceptions;

import com.example.backendfinalproject.security.jwt.JwtAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(NotFoundException e)
    {
        IncorrectData incorrectData = new IncorrectData(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(AlreadyExistException e)
    {
        IncorrectData incorrectData = new IncorrectData(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(BadCredentialsException e)
    {
        IncorrectData incorrectData = new IncorrectData(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.UNAUTHORIZED);
    }
}
