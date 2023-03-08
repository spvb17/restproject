package com.example.backendfinalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class GenreEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="book_genre", joinColumns = @JoinColumn(name="genre_entity_id"), inverseJoinColumns = @JoinColumn(name="book_entity_id"))
    private List<BookEntity> books;

    public GenreEntity(){}
    public GenreEntity(Long id, String name, List<BookEntity> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
