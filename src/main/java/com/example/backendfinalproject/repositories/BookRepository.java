package com.example.backendfinalproject.repositories;

import com.example.backendfinalproject.models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long>
{

}
