package com.example.backendfinalproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserEntityDto
{
    @NotNull(message = "Username field should not be null")
    private String username;
    @Size(min = 1, max = 50, message = "First name field length must be between 1 and 50")
    private String firstName;
    @Size(min = 1, max = 50, message = "Last name field length must be between 1 and 50")
    private String lastName;
    @Email(message = "Entered email does not match the email pattern")
    private String email;
    @Size(min = 4, message = "Password should contain at least 4 signs")
    private String password;

    public UserEntityDto(){}
    public UserEntityDto(String username, String firstName, String lastName, String email, String password)
    {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
