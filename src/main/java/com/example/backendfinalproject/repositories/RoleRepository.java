package com.example.backendfinalproject.repositories;

import com.example.backendfinalproject.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>
{
    RoleEntity findByName(String name);
}
