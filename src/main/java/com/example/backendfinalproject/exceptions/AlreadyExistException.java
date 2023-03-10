package com.example.backendfinalproject.exceptions;

public class AlreadyExistException extends RuntimeException
{
    public AlreadyExistException(String message)
    {
        super(message);
    }
}
