package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private final List<String> books = new ArrayList<>();

    public void addBook(String name, String author) {
        books.add("Book: " + name + ", Author: " + author);
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Books in the library:");
            for (String book : books) {
                System.out.println(book);
            }
        }
    }
}
