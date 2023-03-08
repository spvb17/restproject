package com.example.backendfinalproject.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BasketEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_entity_id")
    private UserEntity user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="basket_book", joinColumns = @JoinColumn(name="basket_entity_id"), inverseJoinColumns = @JoinColumn(name="book_entity_id"))
    private List<BookEntity> books;

    public BasketEntity(){}
    public BasketEntity(Long id, UserEntity user, List<BookEntity> books) {
        this.id = id;
        this.user = user;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
