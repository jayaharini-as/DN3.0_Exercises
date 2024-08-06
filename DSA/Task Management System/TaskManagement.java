// File: TaskManagement.java
import java.util.Scanner;

public class TaskManagement {

    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;
    private Scanner scanner = new Scanner(System.in);

    public TaskManagement() {
        this.head = null;
    }

    public static void main(String[] args) {
        TaskManagement taskManager = new TaskManagement();

        // Adding some predefined tasks
        taskManager.addTask(new Task(1, "Design Homepage", "In Progress"));
        taskManager.addTask(new Task(2, "Develop API", "Completed"));
        taskManager.addTask(new Task(3, "Write Documentation", "Pending"));

        while (true) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = taskManager.scanner.nextInt();
            taskManager.scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    taskManager.addTask();
                    break;
                case 2:
                    taskManager.searchTask();
                    break;
                case 3:
                    taskManager.traverseTasks();
                    break;
                case 4:
                    taskManager.deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addTask() {
        System.out.print("Enter task ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task status: ");
        String status = scanner.nextLine();

        Task newTask = new Task(id, name, status);
        Node newNode = new Node(newTask);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task added successfully.");
    }

    private void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    private void searchTask() {
        System.out.print("Enter task ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == id) {
                System.out.println("Task found: " + current.task);
                return;
            }
            current = current.next;
        }
        System.out.println("Task with ID " + id + " not found.");
    }

    private void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Node current = head;
        System.out.println("Task List:");
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    private void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }

        if (head.task.getTaskId() == id) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != id) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task with ID " + id + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Task deleted successfully.");
        }
    }
}
