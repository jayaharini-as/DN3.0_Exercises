package com.library.service;

import java.util.Scanner;
import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBookFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter book name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Book name cannot be empty.");
                return;
            }

            System.out.print("Enter author name: ");
            String author = scanner.nextLine().trim();

            if (author.isEmpty()) {
                System.out.println("Author name cannot be empty.");
                return;
            }

            bookRepository.addBook(name, author);
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for better debugging
            System.out.println("An error occurred while adding the book: " + e.getMessage());
        }
    }

    public void listBooks() {
        try {
            bookRepository.listBooks();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for better debugging
            System.out.println("An error occurred while listing the books: " + e.getMessage());
        }
    }
}
