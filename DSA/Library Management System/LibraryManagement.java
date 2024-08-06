// File: LibraryManagement.java
import java.util.Arrays;
import java.util.Scanner;

public class LibraryManagement {
    private static Book[] books;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Predefined list of books with Tamil names in English transliteration
        books = new Book[]{
                new Book(1, "Arangam", "Jaan Smith"),
                new Book(2, "Arasar", "Madhan Kumar"),
                new Book(3, "Kadaloram", "Chandran Ram"),
                new Book(4, "Sirpi", "Ajith Kumar"),
                new Book(5, "Sugaadhara", "Vinoth Raja")
        };

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Book by Title (Linear Search)");
            System.out.println("5. Search Book by Title (Binary Search)");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    searchBookLinear();
                    break;
                case 5:
                    searchBookBinary();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        // Create a new book and add it to the array
        Book newBook = new Book(id, title, author);
        books = Arrays.copyOf(books, books.length + 1);
        books[books.length - 1] = newBook;
        System.out.println("Book added successfully.");
    }

    private static void deleteBook() {
        System.out.print("Enter book ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int indexToDelete = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBookId() == id) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Book with ID " + id + " not found.");
            return;
        }

        // Remove the book by shifting the elements
        for (int i = indexToDelete; i < books.length - 1; i++) {
            books[i] = books[i + 1];
        }
        books = Arrays.copyOf(books, books.length - 1);
        System.out.println("Book deleted successfully.");
    }

    private static void updateBook() {
        System.out.print("Enter book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Book book : books) {
            if (book.getBookId() == id) {
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                System.out.print("Enter new author: ");
                String newAuthor = scanner.nextLine();
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    private static void searchBookLinear() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found.");
    }

    private static void searchBookBinary() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();

        int index = binarySearch(books, title);
        if (index >= 0) {
            System.out.println("Book found: " + books[index]);
        } else {
            System.out.println("Book with title '" + title + "' not found.");
        }
    }

    private static int binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Title not found
    }
}
