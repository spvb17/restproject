package com.example.backendfinalproject.services;

import com.example.backendfinalproject.dto.BookDto;
import com.example.backendfinalproject.exceptions.NotFoundException;
import com.example.backendfinalproject.models.BookEntity;
import com.example.backendfinalproject.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BookService(BookRepository bookRepository, ModelMapper modelMapper)
    {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
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

    public void deleteBook(Long id)
    {
        bookRepository.deleteById(id);
    }

    public BookEntity convertToEntity(BookDto bookDto)
    {
        return modelMapper.map(bookDto, BookEntity.class);
    }

    public BookDto convertToDto(BookEntity bookEntity)
    {
        return modelMapper.map(bookEntity, BookDto.class);
    }
}
