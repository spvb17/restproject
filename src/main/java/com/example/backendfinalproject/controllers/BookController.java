package com.example.backendfinalproject.controllers;

import com.example.backendfinalproject.dto.BookDto;
import com.example.backendfinalproject.exceptions.AlreadyExistException;
import com.example.backendfinalproject.exceptions.NotFoundException;
import com.example.backendfinalproject.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
public class BookController
{
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable("id") Long id)
    {
        return bookService.convertToDto(bookService.getBook(id));
    }

    @GetMapping()
    public List<BookDto> getBooks()
    {
        return bookService.getAllBooks().stream().map(x-> bookService.convertToDto(x)).collect(Collectors.toList());
    }

    @PatchMapping("/{id}/add_to_card")
    public void addBookToCard(@PathVariable("id") Long id, Authentication authentication)
    {
        bookService.addToUserCard(id, authentication.getName());
    }

    @PatchMapping("/{id}/delete_from_card")
    public void deleteFromCard(@PathVariable("id") Long id, Authentication authentication)
    {
        bookService.deleteFromUserCard(id, authentication.getName());
    }
}
