import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Predefined products
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(1, "Laptop", "Electronics"));
        productsList.add(new Product(3, "Watch", "Accessories"));
        productsList.add(new Product(2, "Shoes", "Footwear"));

        // Display predefined products
        System.out.println("Predefined Products:");
        for (Product product : productsList) {
            System.out.println(product);
        }

        // Create an array for search operations
        Product[] productsArray = productsList.toArray(new Product[0]);

        // Display the menu
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean running = true;

        while (running) {
            // Display the menu options
            System.out.println("\nMenu:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Add New Product");
            System.out.println("4. Sort Products");
            System.out.println("5. Display Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    // Perform Linear Search
                    System.out.print("Enter Product ID to search: ");
                    int linearSearchId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Product resultLinear = SearchAlgorithms.linearSearch(productsArray, linearSearchId);
                    if (resultLinear != null) {
                        System.out.println("Linear Search Result: " + resultLinear);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 2:
                    // Sort products by productId for Binary Search
                    Arrays.sort(productsArray, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

                    // Perform Binary Search
                    System.out.print("Enter Product ID to search: ");
                    int binarySearchId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Product resultBinary = SearchAlgorithms.binarySearch(productsArray, binarySearchId);
                    if (resultBinary != null) {
                        System.out.println("Binary Search Result: " + resultBinary);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    // Add New Product
                    System.out.print("Enter Product ID: ");
                    int newProductId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Product Name: ");
                    String newProductName = scanner.nextLine();
                    System.out.print("Enter Product Category: ");
                    String newProductCategory = scanner.nextLine();
                    productsList.add(new Product(newProductId, newProductName, newProductCategory));
                    // Update the array
                    productsArray = productsList.toArray(new Product[0]);
                    System.out.println("Product added successfully.");
                    break;

                case 4:
                    // Sort Products
                    Arrays.sort(productsArray, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));
                    System.out.println("Products sorted by ID.");
                    break;

                case 5:
                    // Display Products
                    System.out.println("Products List:");
                    for (Product product : productsArray) {
                        System.out.println(product);
                    }
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        // Close the scanner
        scanner.close();
    }
}
