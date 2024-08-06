## Table of Contents

1. [Data Structures Exercises](#data-structures-exercises)
   - [Exercise 1: Inventory Management System](#exercise-1-inventory-management-system)
   - [Exercise 2: E-commerce Platform Search Function](#exercise-2-e-commerce-platform-search-function)
   - [Exercise 3: Sorting Customer Orders](#exercise-3-sorting-customer-orders)
   - [Exercise 4: Employee Management System](#exercise-4-employee-management-system)
   - [Exercise 5: Task Management System](#exercise-5-task-management-system)
   - [Exercise 6: Library Management System](#exercise-6-library-management-system)
   - [Exercise 7: Financial Forecasting](#exercise-7-financial-forecasting)

2. [Design Patterns and Principles Exercises](#design-patterns-and-principles-exercises)
   - [Exercise 1: Implementing the Singleton Pattern](#exercise-1-implementing-the-singleton-pattern)
   - [Exercise 2: Implementing the Factory Method Pattern](#exercise-2-implementing-the-factory-method-pattern)
   - [Exercise 3: Implementing the Builder Pattern](#exercise-3-implementing-the-builder-pattern)
   - [Exercise 4: Implementing the Adapter Pattern](#exercise-4-implementing-the-adapter-pattern)
   - [Exercise 5: Implementing the Decorator Pattern](#exercise-5-implementing-the-decorator-pattern)
   - [Exercise 6: Implementing the Proxy Pattern](#exercise-6-implementing-the-proxy-pattern)
   - [Exercise 7: Implementing the Observer Pattern](#exercise-7-implementing-the-observer-pattern)
   - [Exercise 8: Implementing the Strategy Pattern](#exercise-8-implementing-the-strategy-pattern)
   - [Exercise 9: Implementing the Command Pattern](#exercise-9-implementing-the-command-pattern)
   - [Exercise 10: Implementing the MVC Pattern](#exercise-10-implementing-the-mvc-pattern)
   - [Exercise 11: Implementing Dependency Injection](#exercise-11-implementing-dependency-injection)

---

## Data Structures Exercises

### Exercise 1: Inventory Management System

**Scenario:**  
You are developing an inventory management system for a warehouse. Efficient data storage and retrieval are crucial.

**Steps:**
1. **Understand the Problem:** Explain the importance of data structures and algorithms in handling large inventories. Discuss suitable data structures like ArrayList or HashMap.
2. **Setup:** Create a new project for the inventory management system.
3. **Implementation:** Define a `Product` class with attributes such as `productId`, `productName`, `quantity`, and `price`. Choose an appropriate data structure for storing products. Implement methods to add, update, and delete products.
4. **Analysis:** Analyze the time complexity of add, update, and delete operations. Discuss optimization strategies.

### Exercise 2: E-commerce Platform Search Function

**Scenario:**  
Optimize search functionality for an e-commerce platform for fast performance.

**Steps:**
1. **Understand Asymptotic Notation:** Explain Big O notation and its use in analyzing algorithms. Describe best, average, and worst-case scenarios for search operations.
2. **Setup:** Create a `Product` class with attributes such as `productId`, `productName`, and `category`.
3. **Implementation:** Implement linear and binary search algorithms. Store products in an array for linear search and a sorted array for binary search.
4. **Analysis:** Compare the time complexity of linear and binary search. Discuss which algorithm is more suitable and why.

### Exercise 3: Sorting Customer Orders

**Scenario:**  
Sort customer orders by total price to prioritize high-value orders.

**Steps:**
1. **Understand Sorting Algorithms:** Explain Bubble Sort, Insertion Sort, Quick Sort, and Merge Sort.
2. **Setup:** Create an `Order` class with attributes like `orderId`, `customerName`, and `totalPrice`.
3. **Implementation:** Implement Bubble Sort and Quick Sort to sort orders by `totalPrice`.
4. **Analysis:** Compare the performance of Bubble Sort and Quick Sort. Discuss why Quick Sort is generally preferred.

### Exercise 4: Employee Management System

**Scenario:**  
Develop an employee management system with efficient record management.

**Steps:**
1. **Understand Array Representation:** Explain how arrays are represented in memory and their advantages.
2. **Setup:** Create an `Employee` class with attributes like `employeeId`, `name`, `position`, and `salary`.
3. **Implementation:** Use an array to store employee records. Implement methods to add, search, traverse, and delete employees.
4. **Analysis:** Analyze the time complexity of each operation. Discuss the limitations of arrays and alternative data structures.

### Exercise 5: Task Management System

**Scenario:**  
Develop a task management system with efficient task management operations.

**Steps:**
1. **Understand Linked Lists:** Explain the types of linked lists (Singly Linked List, Doubly Linked List).
2. **Setup:** Create a `Task` class with attributes like `taskId`, `taskName`, and `status`.
3. **Implementation:** Implement a singly linked list to manage tasks. Implement methods to add, search, traverse, and delete tasks.
4. **Analysis:** Analyze the time complexity of each operation. Discuss advantages of linked lists over arrays for dynamic data.

### Exercise 6: Library Management System

**Scenario:**  
Develop a library management system for searching books by title or author.

**Steps:**
1. **Understand Search Algorithms:** Explain linear and binary search algorithms.
2. **Setup:** Create a `Book` class with attributes like `bookId`, `title`, and `author`.
3. **Implementation:** Implement linear search and binary search for books by title.
4. **Analysis:** Compare time complexity of linear and binary search. Discuss when to use each algorithm based on data size and order.

### Exercise 7: Financial Forecasting

**Scenario:**  
Develop a financial forecasting tool to predict future values based on past data.

**Steps:**
1. **Understand Recursive Algorithms:** Explain recursion and its use in problem-solving.
2. **Setup:** Create a method to calculate future value using recursion.
3. **Implementation:** Implement a recursive algorithm to predict future values.
4. **Analysis:** Discuss the time complexity of the recursive algorithm and optimization strategies to avoid excessive computation.

---

## Design Patterns and Principles Exercises

### Exercise 1: Implementing the Singleton Pattern

**Scenario:**  
Ensure a logging utility class has only one instance throughout the application lifecycle.

**Steps:**
1. **Create a New Java Project:** Create a project named `SingletonPatternExample`.
2. **Define a Singleton Class:** Create a `Logger` class with a private static instance, a private constructor, and a public static method to get the instance.
3. **Implement the Singleton Pattern:** Ensure `Logger` follows the Singleton pattern.
4. **Test the Singleton Implementation:** Verify only one instance of `Logger` is created and used.

### Exercise 2: Implementing the Factory Method Pattern

**Scenario:**  
Create different types of documents (e.g., Word, PDF, Excel) using the Factory Method Pattern.

**Steps:**
1. **Create a New Java Project:** Create a project named `FactoryMethodPatternExample`.
2. **Define Document Classes:** Create interfaces or abstract classes for document types (e.g., `WordDocument`, `PdfDocument`, `ExcelDocument`).
3. **Create Concrete Document Classes:** Implement concrete classes for each document type.
4. **Implement the Factory Method:** Create an abstract `DocumentFactory` class with a `createDocument()` method. Implement concrete factories for each document type.
5. **Test the Factory Method Implementation:** Demonstrate creating different document types using the factory method.

### Exercise 3: Implementing the Builder Pattern

**Scenario:**  
Create complex objects like a Computer with multiple optional parts using the Builder Pattern.

**Steps:**
1. **Create a New Java Project:** Create a project named `BuilderPatternExample`.
2. **Define a Product Class:** Create a `Computer` class with attributes like CPU, RAM, and Storage.
3. **Implement the Builder Class:** Create a static nested `Builder` class inside `Computer` with methods to set each attribute. Provide a `build()` method to return an instance of `Computer`.
4. **Implement the Builder Pattern:** Ensure `Computer` has a private constructor that takes the `Builder` as a parameter.
5. **Test the Builder Implementation:** Demonstrate creating different configurations of `Computer` using the Builder pattern.

### Exercise 4: Implementing the Adapter Pattern

**Scenario:**  
Integrate with multiple third-party payment gateways using the Adapter Pattern.

**Steps:**
1. **Create a New Java Project:** Create a project named `AdapterPatternExample`.
2. **Define Target Interface:** Create a `PaymentProcessor` interface with methods like `processPayment()`.
3. **Implement Adaptee Classes:** Create classes for different payment gateways with their own methods.
4. **Implement the Adapter Class:** Create an adapter class for each gateway that implements `PaymentProcessor` and translates calls to gateway-specific methods.
5. **Test the Adapter Implementation:** Demonstrate using different payment gateways through the adapter.

### Exercise 5: Implementing the Decorator Pattern

**Scenario:**  
Develop a notification system where notifications can be sent via multiple channels

 (e.g., Email, SMS) using the Decorator Pattern.

**Steps:**
1. **Create a New Java Project:** Create a project named `DecoratorPatternExample`.
2. **Define Component Interface:** Create a `Notifier` interface with a `send()` method.
3. **Implement Concrete Component:** Create an `EmailNotifier` class that implements `Notifier`.
4. **Implement Decorator Classes:** Create an abstract `NotifierDecorator` class that implements `Notifier` and holds a reference to a `Notifier` object. Implement concrete decorators like `SMSNotifierDecorator`.
5. **Test the Decorator Implementation:** Demonstrate sending notifications via multiple channels using decorators.

### Exercise 6: Implementing the Proxy Pattern

**Scenario:**  
Implement an image viewer that loads images from a remote server using the Proxy Pattern.

**Steps:**
1. **Create a New Java Project:** Create a project named `ProxyPatternExample`.
2. **Define Subject Interface:** Create an `Image` interface with a `display()` method.
3. **Implement Real Subject Class:** Create a `RealImage` class that implements `Image` and loads an image from a remote server.
4. **Implement Proxy Class:** Create a `ProxyImage` class that implements `Image`, holds a reference to `RealImage`, and implements lazy initialization and caching.
5. **Test the Proxy Implementation:** Demonstrate using `ProxyImage` to load and display images.

### Exercise 7: Implementing the Observer Pattern

**Scenario:**  
Develop a stock market monitoring application where multiple clients need to be notified when stock prices change using the Observer Pattern.

**Steps:**
1. **Create a New Java Project:** Create a project named `ObserverPatternExample`.
2. **Define Subject Interface:** Create a `Stock` interface with methods to register, deregister, and notify observers.
3. **Implement Concrete Subject:** Create a `StockMarket` class that implements `Stock` and maintains a list of observers.
4. **Define Observer Interface:** Create an `Observer` interface with an `update()` method.
5. **Implement Concrete Observers:** Create `MobileApp` and `WebApp` classes that implement `Observer`.
6. **Test the Observer Implementation:** Demonstrate registration and notification of observers.

### Exercise 8: Implementing the Strategy Pattern

**Scenario:**  
Develop a payment system with selectable payment methods (e.g., Credit Card, PayPal) at runtime using the Strategy Pattern.

**Steps:**
1. **Create a New Java Project:** Create a project named `StrategyPatternExample`.
2. **Define Strategy Interface:** Create a `PaymentStrategy` interface with a `pay()` method.
3. **Implement Concrete Strategies:** Create `CreditCardPayment` and `PayPalPayment` classes that implement `PaymentStrategy`.
4. **Implement Context Class:** Create a `PaymentContext` class that holds a reference to `PaymentStrategy` and executes the strategy.
5. **Test the Strategy Implementation:** Demonstrate selecting and using different payment strategies.

### Exercise 9: Implementing the Command Pattern

**Scenario:**  
Develop a home automation system with commands to turn devices on or off using the Command Pattern.

**Steps:**
1. **Create a New Java Project:** Create a project named `CommandPatternExample`.
2. **Define Command Interface:** Create a `Command` interface with an `execute()` method.
3. **Implement Concrete Commands:** Create `LightOnCommand` and `LightOffCommand` classes that implement `Command`.
4. **Implement Invoker Class:** Create a `RemoteControl` class that holds a reference to a `Command` and executes it.
5. **Implement Receiver Class:** Create a `Light` class with methods to turn on and off.
6. **Test the Command Implementation:** Demonstrate issuing commands using `RemoteControl`.

### Exercise 10: Implementing the MVC Pattern

**Scenario:**  
Develop a simple web application for managing student records using the MVC pattern.

**Steps:**
1. **Create a New Java Project:** Create a project named `MVCPatternExample`.
2. **Define Model Class:** Create a `Student` class with attributes like `name`, `id`, and `grade`.
3. **Define View Class:** Create a `StudentView` class with a `displayStudentDetails()` method.
4. **Define Controller Class:** Create a `StudentController` class that manages communication between the model and view.
5. **Test the MVC Implementation:** Demonstrate creating a `Student`, updating its details using `StudentController`, and displaying them with `StudentView`.

### Exercise 11: Implementing Dependency Injection

**Scenario:**  
Develop a customer management application using Dependency Injection to manage dependencies.

**Steps:**
1. **Create a New Java Project:** Create a project named `DependencyInjectionExample`.
2. **Define Repository Interface:** Create a `CustomerRepository` interface with methods like `findCustomerById()`.
3. **Implement Concrete Repository:** Create a `CustomerRepositoryImpl` class that implements `CustomerRepository`.
4. **Define Service Class:** Create a `CustomerService` class that depends on `CustomerRepository`.
5. **Implement Dependency Injection:** Use constructor injection to inject `CustomerRepository` into `CustomerService`.
6. **Test the Dependency Injection Implementation:** Demonstrate creating `CustomerService` with `CustomerRepositoryImpl` and using it to find a customer.

---


