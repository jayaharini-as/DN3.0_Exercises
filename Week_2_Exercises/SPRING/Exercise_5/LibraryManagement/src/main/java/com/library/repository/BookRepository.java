package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<String> books = new ArrayList<>();

    // Method to add a book
    public void addBook(String name, String author) {
        books.add(name + " by " + author);
    }

    // Method to list all books
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (String book : books) {
                System.out.println(book);
            }
        }
    }
}
