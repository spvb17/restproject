package com.example.backendfinalproject.controllers;

import com.example.backendfinalproject.models.BookEntity;
import com.example.backendfinalproject.models.UserEntity;
import com.example.backendfinalproject.services.BookService;
import com.example.backendfinalproject.services.UserService;
import jakarta.validation.Valid;
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
    public UserEntity getUserById(@PathVariable("id") Long id)
    {
        return userService.findById(id);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PatchMapping("/users/{id}/deleted_account")
    public UserEntity statusToDeleted(@PathVariable("id") Long id)
    {
        return userService.statusToDeleted(id);
    }

    @PatchMapping("/users/{id}/non_active_account")
    public UserEntity statusToNonActive(@PathVariable("id") Long id)
    {
        return userService.statusToNonActive(id);
    }

    @PatchMapping("/users/{id}/active_account")
    public UserEntity statusToActive(@PathVariable("id") Long id)
    {
        return userService.statusToActive(id);
    }

    @GetMapping("/books")
    public List<BookEntity> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public BookEntity getBook(@PathVariable("id") Long id)
    {
        return bookService.getBook(id);
    }

    @DeleteMapping("/books/{id}/delete")
    public void deleteBook(@PathVariable("id") Long id)
    {
        bookService.deleteBook(id);
    }

    @PostMapping("books/new")
    public void addBook(@RequestBody @Valid BookEntity bookEntity)
    {
        bookService.addBook(bookEntity);
    }

    @PatchMapping("/books/update")
    public BookEntity updateBook(@RequestBody BookEntity bookEntity)
    {
        return bookService.updateBook(bookEntity);
    }
}
