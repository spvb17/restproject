package com.example.backendfinalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BookEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double rating;
    private String author;
    private String image;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="basket_book", joinColumns = @JoinColumn(name="book_entity_id"), inverseJoinColumns = @JoinColumn(name="basket_entity_id"))
    private List<BasketEntity> baskets;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="book_genre", joinColumns = @JoinColumn(name="book_entity_id"), inverseJoinColumns = @JoinColumn(name="genre_entity_id"))
    private List<GenreEntity> genres;

    public BookEntity() {}
    public BookEntity(Long id, String name, double price, double rating, String author, String image, List<BasketEntity> baskets, List<GenreEntity> genres) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.author = author;
        this.image = image;
        this.baskets = baskets;
        this.genres = genres;
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

    public List<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreEntity> genres) {
        this.genres = genres;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<BasketEntity> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<BasketEntity> baskets) {
        this.baskets = baskets;
    }
}
