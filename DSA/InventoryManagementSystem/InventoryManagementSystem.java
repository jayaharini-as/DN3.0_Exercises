// InventoryManagementSystem.java
import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<String, Product> inventory = new HashMap<>();

    // Add a product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("[INFO] Product added: " + product);
    }

    // Update a product
    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
            System.out.println("[INFO] Product updated: " + updatedProduct);
        } else {
            System.out.println("[ERROR] Product with ID " + productId + " does not exist.");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            Product removedProduct = inventory.remove(productId);
            System.out.println("[INFO] Product removed: " + removedProduct);
        } else {
            System.out.println("[ERROR] Product with ID " + productId + " does not exist.");
        }
    }

    // Display all products
    public void displayAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("[INFO] No products in inventory.");
        } else {
            System.out.println("[INFO] All Products in Inventory:");
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

    // Find a product by ID
    public Product findProductById(String productId) {
        return inventory.get(productId);
    }
}
