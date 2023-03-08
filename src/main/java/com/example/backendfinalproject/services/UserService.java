package com.example.backendfinalproject.services;

import com.example.backendfinalproject.dto.UserEntityDto;
import com.example.backendfinalproject.exceptions.NotFoundException;
import com.example.backendfinalproject.models.AccountStatus;
import com.example.backendfinalproject.models.RoleEntity;
import com.example.backendfinalproject.models.UserEntity;
import com.example.backendfinalproject.repositories.RoleRepository;
import com.example.backendfinalproject.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserEntity register(UserEntityDto userEntityDto)
    {
        UserEntity userEntity = new UserEntity();
        RoleEntity role = roleRepository.findByName("ROLE_USER");
        List<RoleEntity> userRoles = new ArrayList<>();
        userRoles.add(role);
        userEntity.setUsername(userEntityDto.getUsername());
        userEntity.setFirstName(userEntityDto.getFirstName());
        userEntity.setLastName(userEntityDto.getLastName());
        userEntity.setEmail(userEntityDto.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userEntityDto.getPassword()));
        userEntity.setRoles(userRoles);
        userEntity.setAccountStatus(AccountStatus.ACTIVE);

        userRepository.save(userEntity);
        return userEntity;
    }

    public List<UserEntity> getAll()
    {
        return userRepository.findAll();
    }

    public UserEntity findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    public UserEntity findById(Long id) throws NotFoundException
    {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with id "+id+" doesn't exist!"));
    }

    public List<UserEntity> getAllUsers()
    {
        return userRepository.findAll();
    }
}
