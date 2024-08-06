// File: Main.java
import java.util.Scanner;

public class Main {

    private static Employee[] employees = new Employee[100]; // Initial capacity of 100
    private static int size = 0; // Number of employees currently in the array
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Predefined Indian employee values
        initializeEmployees();

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    traverseEmployees();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void initializeEmployees() {
        employees[size++] = new Employee(101, "Rajesh Kumar", "Software Engineer", 75000);
        employees[size++] = new Employee(102, "Aisha Patel", "HR Manager", 85000);
        employees[size++] = new Employee(103, "Vikram Singh", "Project Lead", 95000);
        employees[size++] = new Employee(104, "Anjali Sharma", "Data Analyst", 70000);
        employees[size++] = new Employee(105, "Suresh Reddy", "DevOps Engineer", 80000);
    }

    private static void addEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter position: ");
        String position = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        if (size >= employees.length) {
            System.out.println("Employee array is full. Cannot add more employees.");
            return;
        }

        employees[size++] = new Employee(id, name, position, salary);
        System.out.println("Employee added successfully.");
    }

    private static void searchEmployee() {
        System.out.print("Enter employee ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == id) {
                System.out.println("Employee found: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    private static void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("Employee List:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        int indexToRemove = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == id) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            System.out.println("Employee with ID " + id + " not found.");
            return;
        }

        for (int i = indexToRemove; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null; // Remove reference to the last employee
        size--;
        System.out.println("Employee deleted successfully.");
    }
}
