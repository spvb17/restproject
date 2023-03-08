package com.example.backendfinalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class RoleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="role_entity_id"), inverseJoinColumns = @JoinColumn(name="user_entity_id"))
    private List<UserEntity> users;

    public RoleEntity(){}
    public RoleEntity(Long id, String name, List<UserEntity> users)
    {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<UserEntity> getUsers()
    {
        return users;
    }

    public void setUsers(List<UserEntity> users)
    {
        this.users = users;
    }
}
