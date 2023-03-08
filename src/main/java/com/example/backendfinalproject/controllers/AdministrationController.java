package com.example.backendfinalproject.controllers;

import com.example.backendfinalproject.exceptions.NotFoundException;
import com.example.backendfinalproject.models.UserEntity;
import com.example.backendfinalproject.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/")
public class AdministrationController
{
    private final UserService userService;
    @Autowired
    public AdministrationController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id) throws NotFoundException
    {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers()
    {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
