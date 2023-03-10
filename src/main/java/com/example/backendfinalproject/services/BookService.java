package com.example.backendfinalproject.services;

import com.example.backendfinalproject.dto.BookDto;
import com.example.backendfinalproject.exceptions.AlreadyExistException;
import com.example.backendfinalproject.exceptions.NotFoundException;
import com.example.backendfinalproject.models.BasketEntity;
import com.example.backendfinalproject.models.BookEntity;
import com.example.backendfinalproject.models.UserEntity;
import com.example.backendfinalproject.repositories.BasketRepository;
import com.example.backendfinalproject.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    private final BookRepository bookRepository;
    private final BasketRepository basketRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BasketRepository basketRepository, UserService userService, ModelMapper modelMapper)
    {
        this.bookRepository = bookRepository;
        this.basketRepository = basketRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public List<BookEntity> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public BookEntity getBook(Long id)
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

    public BookEntity updateBook(BookEntity bookEntity)
    {
        bookRepository.save(bookEntity);
        return bookEntity;
    }

    public void addToUserCard(Long id, String username)
    {
        UserEntity userEntity = userService.findByUsername(username);
        BasketEntity basketEntity = basketRepository.findById(userEntity.getId()).get();
        BookEntity bookEntity = getBook(id);

        List<BookEntity> books = basketEntity.getBooks();
        for(BookEntity book:books)
        {
            if(book.getId().equals(id))
            {
                throw new AlreadyExistException("You already have this book in your card!");
            }
        }
        books.add(bookEntity);
        basketRepository.save(basketEntity);
    }

    public void deleteFromUserCard(Long id, String username)
    {
        UserEntity userEntity = userService.findByUsername(username);
        BasketEntity basketEntity = basketRepository.findById(userEntity.getId()).get();
        List<BookEntity> books = basketEntity.getBooks();
        books.removeIf(book -> book.getId().equals(id));
        userService.save(userEntity);
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
