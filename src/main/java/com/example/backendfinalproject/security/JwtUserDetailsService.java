package com.example.backendfinalproject.security;

import com.example.backendfinalproject.models.UserEntity;
import com.example.backendfinalproject.security.jwt.JwtUserFactory;
import com.example.backendfinalproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService
{
    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserEntity user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " was not found");
        }
        return JwtUserFactory.create(user);
    }
}
