// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Add default products
        initializeDefaultProducts(ims);

        while (true) {
            // Display menu
            System.out.println("\n*** Inventory Management System ***");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Find Product by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    // Add Product
                    System.out.print("Enter Product ID: ");
                    String addId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int addQuantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double addPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline left-over
                    Product newProduct = new Product(addId, addName, addQuantity, addPrice);
                    ims.addProduct(newProduct);
                    break;

                case 2:
                    // Update Product
                    System.out.print("Enter Product ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter New Product Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int updateQuantity = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double updatePrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline left-over
                    Product updatedProduct = new Product(updateId, updateName, updateQuantity, updatePrice);
                    ims.updateProduct(updateId, updatedProduct);
                    break;

                case 3:
                    // Delete Product
                    System.out.print("Enter Product ID to delete: ");
                    String deleteId = scanner.nextLine();
                    ims.deleteProduct(deleteId);
                    break;

                case 4:
                    // Display All Products
                    ims.displayAllProducts();
                    break;

                case 5:
                    // Find Product by ID
                    System.out.print("Enter Product ID to find: ");
                    String findId = scanner.nextLine();
                    Product foundProduct = ims.findProductById(findId);
                    if (foundProduct != null) {
                        System.out.println("Product Found: " + foundProduct);
                    } else {
                        System.out.println("Product with ID " + findId + " not found.");
                    }
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting the Inventory Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option (1-6).");
                    break;
            }
        }
    }

    private static void initializeDefaultProducts(InventoryManagementSystem ims) {
        // Adding default products
        Product p1 = new Product("001", "Laptop", 10, 1200.00);
        Product p2 = new Product("002", "Smartphone", 25, 800.00);
        Product p3 = new Product("003", "Tablet", 15, 300.00);
        Product p4 = new Product("004", "Headphones", 50, 100.00);
        Product p5 = new Product("005", "Smartwatch", 20, 200.00);

        ims.addProduct(p1);
        ims.addProduct(p2);
        ims.addProduct(p3);
        ims.addProduct(p4);
        ims.addProduct(p5);

        System.out.println("[INFO] Default products have been added to the inventory.");
    }
}
