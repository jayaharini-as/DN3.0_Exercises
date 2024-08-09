package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Menu-driven loop
        int choice;
        do {
            System.out.println("Library Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. List Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a book
                    bookService.addBookFromUserInput();
                    break;

                case 2:
                    // List all books
                    bookService.listBooks();
                    break;

                case 3:
                    // Exit the application
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }
}
