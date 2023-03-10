package com.example.backendfinalproject.exceptions;

public class NotFoundException extends RuntimeException
{
    public NotFoundException(String message)
    {
        super(message);
    }
}
