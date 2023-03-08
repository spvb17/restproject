package com.example.backendfinalproject.controllers;

import com.example.backendfinalproject.dto.BookDto;
import com.example.backendfinalproject.exceptions.NotFoundException;
import com.example.backendfinalproject.models.BookEntity;
import com.example.backendfinalproject.models.UserEntity;
import com.example.backendfinalproject.services.BookService;
import com.example.backendfinalproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/")
public class AdministrationController
{
    private final UserService userService;
    private final BookService bookService;
    @Autowired
    public AdministrationController(UserService userService, BookService bookService)
    {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/users/{id}")
    public UserEntity getUserById(@PathVariable("id") Long id) throws NotFoundException
    {
        return userService.findById(id);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/books")
    public List<BookEntity> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public BookEntity getBook(@PathVariable("id") Long id) throws NotFoundException
    {
        return bookService.getBook(id);
    }

    @PostMapping("books/new")
    public void addBook(@RequestBody BookDto bookDto)
    {
        bookService.addBook(bookService.convertToEntity(bookDto));
    }

    @DeleteMapping("books/{id}/delete")
    public void deleteBook(@PathVariable("id") Long id)
    {
        bookService.deleteBook(id);
    }
}
