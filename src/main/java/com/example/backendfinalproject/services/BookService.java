package com.example.backendfinalproject.services;

import com.example.backendfinalproject.exceptions.NotFoundException;
import com.example.backendfinalproject.models.BookEntity;
import com.example.backendfinalproject.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public BookEntity getBook(Long id) throws NotFoundException
    {
        return bookRepository.findById(id).orElseThrow(()->new NotFoundException("Book with id "+id+" doesn't exist!"));
    }

    public void addBook(BookEntity bookEntity)
    {
        bookRepository.save(bookEntity);
    }
}
