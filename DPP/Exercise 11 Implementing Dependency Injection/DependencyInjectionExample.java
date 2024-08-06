import java.util.Scanner;

// Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
    void addCustomer(int id, String name);
    void deleteCustomer(int id);
}

// Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    private final java.util.Map<Integer, String> customerMap = new java.util.HashMap<>();

    public CustomerRepositoryImpl() {
        // Adding some predefined customers
        customerMap.put(1, "JAYA");
        customerMap.put(2, "VETRI");
    }

    @Override
    public String findCustomerById(int id) {
        return customerMap.getOrDefault(id, "Customer Not Found");
    }

    @Override
    public void addCustomer(int id, String name) {
        customerMap.put(id, name);
        System.out.println("Customer added: ID " + id + ", Name " + name);
    }

    @Override
    public void deleteCustomer(int id) {
        if (customerMap.remove(id) != null) {
            System.out.println("Customer deleted: ID " + id);
        } else {
            System.out.println("Customer ID " + id + " not found.");
        }
    }
}

// Service Class
class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerName(int id) {
        return customerRepository.findCustomerById(id);
    }

    public void addCustomer(int id, String name) {
        customerRepository.addCustomer(id, name);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }
}

// Main Class
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create an instance of CustomerRepository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject the repository into CustomerService
        CustomerService service = new CustomerService(repository);

        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n=== Customer Management System ===");
            System.out.println("1. Add Customer");
            System.out.println("2. Search Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID to add: ");
                    int addId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Customer Name: ");
                    String addName = scanner.nextLine();
                    service.addCustomer(addId, addName);
                    break;
                
                case 2:
                    System.out.print("Enter Customer ID to search: ");
                    int searchId = scanner.nextInt();
                    String customerName = service.getCustomerName(searchId);
                    System.out.println("Customer found: ID " + searchId + ", Name " + customerName);
                    break;

                case 3:
                    System.out.print("Enter Customer ID to delete: ");
                    int deleteId = scanner.nextInt();
                    service.deleteCustomer(deleteId);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}
