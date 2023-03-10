package com.example.backendfinalproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Last name field should not be null")
    @NotNull(message = "Username field should not be null")
    private String username;
    @NotNull(message = "First name field should not be null")
    @Size(min = 1, max = 50, message = "First name field length must be between 1 and 50")
    private String firstName;
    @NotNull(message = "Last name field should not be null")
    @Size(min = 1, max = 50, message = "Last name field length must be between 1 and 50")
    private String lastName;
    @NotNull(message = "Email field should not be null")
    @Email(message = "Entered email does not match the email pattern")
    private String email;
    @NotNull(message = "Password field should not be null")
    @Size(min = 4, message = "Password should contain at least 4 signs")
    private String password;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_entity_id"), inverseJoinColumns = @JoinColumn(name="role_entity_id"))
    private List<RoleEntity> roles;


    public UserEntity(){}
    public UserEntity(Long id, String username, String firstName, String lastName, String email, String password, AccountStatus accountStatus, List<RoleEntity> roles)
    {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accountStatus = accountStatus;
        this.roles = roles;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
