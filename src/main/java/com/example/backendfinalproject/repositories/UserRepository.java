package com.example.backendfinalproject.repositories;

import com.example.backendfinalproject.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    UserEntity findByUsername(String username);

    List<UserEntity> findAll();
}
