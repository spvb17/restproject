package com.example.backendfinalproject.services;

import com.example.backendfinalproject.dto.UserDto;
import com.example.backendfinalproject.exceptions.AlreadyExistException;
import com.example.backendfinalproject.exceptions.NotFoundException;
import com.example.backendfinalproject.models.*;
import com.example.backendfinalproject.repositories.BasketRepository;
import com.example.backendfinalproject.repositories.RoleRepository;
import com.example.backendfinalproject.repositories.UserRepository;
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
    private final BasketRepository basketRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BasketRepository basketRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.basketRepository = basketRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserEntity register(UserDto userDto)
    {
        if(findByUsername(userDto.getUsername())!=null)
        {
            throw new AlreadyExistException("This username is not available!");
        }
        UserEntity userEntity = new UserEntity();
        RoleEntity role = roleRepository.findByName("ROLE_USER");
        List<RoleEntity> userRoles = new ArrayList<>();
        userRoles.add(role);
        userEntity.setUsername(userDto.getUsername());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setRoles(userRoles);
        userEntity.setAccountStatus(AccountStatus.ACTIVE);
        userRepository.save(userEntity);

        List<BookEntity> books = new ArrayList<>();
        BasketEntity basketEntity = new BasketEntity();
        basketEntity.setId(userEntity.getId());
        basketEntity.setBooks(books);
        basketEntity.setUser(userEntity);
        basketRepository.save(basketEntity);

        return userEntity;
    }

    public UserEntity findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    public UserEntity findById(Long id)
    {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with id "+id+" doesn't exist!"));
    }

    public List<UserEntity> getAllUsers()
    {
        return userRepository.findAll();
    }

    public UserEntity statusToDeleted(Long id)
    {
        UserEntity userEntity = userRepository.findById(id).orElse(findById(id));
        userEntity.setAccountStatus(AccountStatus.DELETED);
        userRepository.save(userEntity);
        return userEntity;
    }

    public UserEntity statusToNonActive(Long id)
    {
        UserEntity userEntity = userRepository.findById(id).orElse(findById(id));
        userEntity.setAccountStatus(AccountStatus.NOT_ACTIVE);
        userRepository.save(userEntity);
        return userEntity;
    }

    public UserEntity statusToActive(Long id)
    {
        UserEntity userEntity = userRepository.findById(id).orElse(findById(id));
        userEntity.setAccountStatus(AccountStatus.ACTIVE);
        userRepository.save(userEntity);
        return userEntity;
    }

    public void save(UserEntity userEntity)
    {
        userRepository.save(userEntity);
    }

    public void makeAdmin(Long id)
    {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()->new NotFoundException("This user doesn't exist"));
        List<RoleEntity> userRoles = userEntity.getRoles();
        RoleEntity role = roleRepository.findByName("ROLE_ADMIN");
        userRoles.add(role);
        userEntity.setRoles(userRoles);
        userRepository.save(userEntity);
    }
}
