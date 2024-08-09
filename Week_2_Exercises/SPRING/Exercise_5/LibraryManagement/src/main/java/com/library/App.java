package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Load the Spring context from the XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean from the Spring context
        BookService bookService = (BookService) context.getBean("bookService");

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Library Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. List Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book name: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String authorName = scanner.nextLine();
                    bookService.addBook(bookName, authorName);
                    break;
                case 2:
                    // Add code here to list books if implemented
                    System.out.println("Listing books functionality is not yet implemented.");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

        // Close the scanner
        scanner.close();
    }
}
