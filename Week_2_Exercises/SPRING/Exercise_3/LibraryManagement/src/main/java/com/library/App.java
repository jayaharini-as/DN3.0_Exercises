package com.library;

import com.library.service.BookService;
import com.library.repository.BookRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");

        while (true) {
            try {
                System.out.println("Library Management System");
                System.out.println("1. Add a Book");
                System.out.println("2. List Books");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        bookService.addBookFromUserInput();
                        break;
                    case 2:
                        bookService.listBooks();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace(); // Print stack trace for better debugging
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }



    
}
