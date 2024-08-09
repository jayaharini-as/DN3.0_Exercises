package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter method for BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Method to add a book
    public void addBook(String name, String author) {
        bookRepository.addBook(name, author);
        System.out.println("Book added: " + name + " by " + author);
    }

    // Method to list all books
    public void listBooks() {
        bookRepository.listBooks();
    }
}
