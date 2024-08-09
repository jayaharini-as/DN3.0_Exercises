package com.library.service;
import java.util.Scanner;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Method to add a book from user input
    public void addBookFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book name: ");
        String name = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        bookRepository.addBook(name, author);
        System.out.println("Book added successfully!");
    }

    // Method to list all books
    public void listBooks() {
        bookRepository.listBooks();
    }
}
