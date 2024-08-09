package com.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService {

    private List<String> books = new ArrayList<>();

    @Override
    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book name:");
        String bookName = scanner.nextLine();
        books.add(bookName);
        System.out.println("Book added: " + bookName);
    }

    @Override
    public List<String> getBooks() {
        System.out.println("Fetching list of books...");
        return books;
    }
}
