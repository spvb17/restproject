package com.example.backendfinalproject.security.jwt;

public class JwtAuthenticationException extends RuntimeException
{
    public JwtAuthenticationException(String msg)
    {
        super(msg);
    }
}
