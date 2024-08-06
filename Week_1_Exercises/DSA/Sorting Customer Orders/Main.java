import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Order> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample initial orders with Indian names
        orders.add(new Order(1, "Aarav", 250.0));
        orders.add(new Order(2, "Vihaan", 100.0));
        orders.add(new Order(3, "Ishaan", 300.0));
        orders.add(new Order(4, "Aanya", 150.0));

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Order");
            System.out.println("2. Update Order");
            System.out.println("3. Delete Order");
            System.out.println("4. Print Orders");
            System.out.println("5. Sort Orders");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    updateOrder();
                    break;
                case 3:
                    deleteOrder();
                    break;
                case 4:
                    printOrders();
                    break;
                case 5:
                    sortOrders();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addOrder() {
        System.out.print("Enter order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter total price: ");
        double totalPrice = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        orders.add(new Order(orderId, customerName, totalPrice));
        System.out.println("Order added successfully.");
    }

    private static void updateOrder() {
        System.out.print("Enter order ID to update: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                System.out.print("Enter new customer name: ");
                String customerName = scanner.nextLine();
                System.out.print("Enter new total price: ");
                double totalPrice = scanner.nextDouble();
                scanner.nextLine();  // Consume newline

                order.setCustomerName(customerName);
                order.setTotalPrice(totalPrice);
                System.out.println("Order updated successfully.");
                return;
            }
        }
        System.out.println("Order ID not found.");
    }

    private static void deleteOrder() {
        System.out.print("Enter order ID to delete: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Order toRemove = null;
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                toRemove = order;
                break;
            }
        }

        if (toRemove != null) {
            orders.remove(toRemove);
            System.out.println("Order deleted successfully.");
        } else {
            System.out.println("Order ID not found.");
        }
    }

    private static void printOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders to display.");
        } else {
            System.out.println("Orders:");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    private static void sortOrders() {
        System.out.println("Select sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        long startTime = System.nanoTime();
        switch (option) {
            case 1:
                Algorithms.bubbleSort(orders);
                System.out.println("Sorted using Bubble Sort.");
                break;
            case 2:
                Algorithms.quickSort(orders, 0, orders.size() - 1);
                System.out.println("Sorted using Quick Sort.");
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }
        long endTime = System.nanoTime();
        printOrders();
        System.out.println("Sorting Time: " + (endTime - startTime) + " nanoseconds");
    }

    // Order class definition
    public static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId=" + orderId +
                    ", customerName='" + customerName + '\'' +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }
}
