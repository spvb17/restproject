package com.example.backendfinalproject.dto;

import java.util.List;

public class BookDto
{
    private String name;
    private double price;
    private double rating;
    private String author;
    private String image;
    private List<GenreDto> genres;

    public BookDto(){}
    public BookDto(String name, double price, double rating, String author, String image, List<GenreDto> genres) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.author = author;
        this.image = image;
        this.genres = genres;
    }

    public String getName() {
        return name;
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

    public List<GenreDto> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreDto> genres) {
        this.genres = genres;
    }
}
