package com.library.repository;

import com.library.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    // Method to save the book
    public void save(Book book) {
        // Save book to database or in-memory storage
        System.out.println("Book saved: " + book);
    }
}
