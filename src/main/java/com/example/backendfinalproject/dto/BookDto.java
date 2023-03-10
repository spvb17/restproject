package com.example.backendfinalproject.dto;

import com.example.backendfinalproject.models.GenreEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class BookDto
{
    @NotNull(message = "Name field should not be null")
    private String name;
    @Min(value = 0, message = "Price should not be with minus sign")
    private double price;
    @Min(value = 0, message = "Rating field should not be with minus sign")
    @Max(value = 10, message = "Max rating for book is 10")
    private double rating;
    @NotNull(message = "Book author should not be null")
    @Size(min = 1, max = 100, message = "Author field length should be between 1 and 100")
    private String author;
    private String image;
    private List<GenreDto> genres;

    public BookDto(){}
    public BookDto(String name, double price, double rating, String author, String image, List<GenreDto> genres)
    {
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
