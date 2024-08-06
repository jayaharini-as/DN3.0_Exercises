import java.util.Scanner;

// Model Class
class Student {
    private String name;
    private int id;
    private String grade;

    // Constructor
    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// View Class
class StudentView {
    public void displayStudentDetails(String studentName, int studentId, String studentGrade) {
        System.out.println("**********************************");
        System.out.println("         Student Record System     ");
        System.out.println("**********************************");
        System.out.println("Student Details:");
        System.out.println("-----------------");
        System.out.printf("Name  : %s\n", studentName);
        System.out.printf("ID    : %d\n", studentId);
        System.out.printf("Grade : %s\n", studentGrade);
        System.out.println("**********************************");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

// Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    // Constructor
    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentId(int id) {
        model.setId(id);
    }

    public int getStudentId() {
        return model.getId();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// Main Class with Menu
public class MVCPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student("", 0, "");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        boolean running = true;

        while (running) {
            System.out.println("=== Student Record System Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Student Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:  // Add Student
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    controller = new StudentController(new Student(name, id, grade), view);
                    view.displayMessage("Student added successfully.");
                    break;

                case 2:  // Update Student
                    System.out.print("Enter new student name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new student ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new student grade: ");
                    grade = scanner.nextLine();
                    controller.setStudentName(name);
                    controller.setStudentId(id);
                    controller.setStudentGrade(grade);
                    view.displayMessage("Student updated successfully.");
                    break;

                case 3:  // Delete Student
                    // Here we will just clear the existing data for simplicity
                    controller = new StudentController(new Student("", 0, ""), view);
                    view.displayMessage("Student record deleted successfully.");
                    break;

                case 4:  // Display Student Details
                    controller.updateView();
                    break;

                case 5:  // Exit
                    running = false;
                    System.out.println("Exiting the Student Record System.");
                    break;

                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
