package com.library.service;

import com.library.domain.Book;
import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor-based dependency injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String name, String author) {
        bookRepository.save(new Book(name, author));
    }
    
    // Other service methods
}
