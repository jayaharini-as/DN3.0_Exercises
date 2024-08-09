package com.library.service;

import com.library.repository.BookRepository;

import java.util.Scanner;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBookFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book name: ");
        String name = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        bookRepository.addBook(name, author);
        System.out.println("Book added successfully!");
    }

    public void listBooks() {
        bookRepository.listBooks();
    }
}
