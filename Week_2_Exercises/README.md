# Library Management System

This repository contains exercises for working with PL/SQL and Spring Framework, aimed at managing a library system. Below is an overview of the tasks and scenarios covered in each exercise.

## PL/SQL Exercises

### Exercise 1: Control Structures
- **Scenario 1: Discount Loan Interest Rates**  
  Apply a 1% discount to loan interest rates for customers above 60 years old.
- **Scenario 2: VIP Customer Promotion**  
  Promote customers to VIP status if their balance exceeds $10,000.
- **Scenario 3: Loan Reminders**  
  Send reminders to customers with loans due within the next 30 days.

### Exercise 2: Error Handling
- **Scenario 1: Fund Transfer Error Handling**  
  Create a stored procedure to safely transfer funds between accounts, handling errors such as insufficient funds.
- **Scenario 2: Salary Update Error Handling**  
  Develop a procedure to update employee salaries, managing exceptions for non-existent employee IDs.
- **Scenario 3: Customer Addition Integrity**  
  Ensure no duplicate customer IDs are added when inserting a new customer.

### Exercise 3: Stored Procedures
- **Scenario 1: Monthly Interest Processing**  
  Implement a procedure to update savings account balances with a 1% interest rate monthly.
- **Scenario 2: Employee Bonus Scheme**  
  Write a procedure to apply a bonus to employees' salaries based on their department.
- **Scenario 3: Fund Transfer**  
  Create a procedure to transfer funds between accounts, checking for sufficient balance.

### Exercise 4: Functions
- **Scenario 1: Calculate Customer Age**  
  Develop a function to calculate a customer's age from their date of birth.
- **Scenario 2: Monthly Loan Installment**  
  Write a function to compute the monthly installment for a loan based on amount, interest rate, and duration.
- **Scenario 3: Balance Check**  
  Create a function to check if an account has sufficient balance for a transaction.

### Exercise 5: Triggers
- **Scenario 1: Update Last Modified Date**  
  Automatically update the `LastModified` column of the `Customers` table on record updates.
- **Scenario 2: Audit Log Maintenance**  
  Insert records into an `AuditLog` table for each transaction.
- **Scenario 3: Transaction Rules Enforcement**  
  Ensure withdrawals do not exceed the balance and deposits are positive before transaction insertion.

### Exercise 6: Cursors
- **Scenario 1: Monthly Statements**  
  Retrieve all transactions for the current month and print statements for each customer.
- **Scenario 2: Annual Fee Application**  
  Deduct an annual maintenance fee from all account balances.
- **Scenario 3: Update Loan Interest Rates**  
  Fetch and update interest rates for all loans based on a new policy.

### Exercise 7: Packages
- **Scenario 1: Customer Management Package**  
  Create a package to manage customer-related procedures and functions.
- **Scenario 2: Employee Management Package**  
  Develop a package to manage employee data.
- **Scenario 3: Account Operations Package**  
  Group account-related procedures and functions into a package.

## Spring Framework Exercises

### Exercise 1: Configuring a Basic Spring Application
- **Scenario:** Set up a Spring project for managing a library with basic configuration and bean definitions.

### Exercise 2: Implementing Dependency Injection
- **Scenario:** Manage dependencies between `BookService` and `BookRepository` using Spring's IoC and DI.

### Exercise 3: Implementing Logging with Spring AOP
- **Scenario:** Add logging capabilities to track method execution times using Spring AOP.

### Exercise 4: Creating and Configuring a Maven Project
- **Scenario:** Set up a Maven project and add necessary Spring dependencies for the library management application.

### Exercise 5: Configuring the Spring IoC Container
- **Scenario:** Configure beans and dependencies for the library management application using XML configuration.

### Exercise 6: Configuring Beans with Annotations
- **Scenario:** Simplify bean configuration using annotations for the library management application.

### Exercise 7: Implementing Constructor and Setter Injection
- **Scenario:** Use both constructor and setter injection for bean initialization in the library management application.

### Exercise 8: Implementing Basic AOP with Spring
- **Scenario:** Define and configure basic AOP functionality for logging and transaction management.

### Exercise 9: Creating a Spring Boot Application
- **Scenario:** Create and configure a Spring Boot application for the library management system, including REST endpoints and database setup.

## Schema to be Created

Tables to be created:
- `Customers`
- `Accounts`
- `Transactions`
- `Loans`
- `Employees`

## Sample Data Insertion

- Insert sample data into `Customers`, `Accounts`, `Transactions`, `Loans`, and `Employees` tables.

## Setup and Configuration

### For Spring Boot Application
1. **Create Spring Boot Project**  
   Use Spring Initializr to set up the project.
2. **Add Dependencies**  
   Include dependencies for Spring Web, Spring Data JPA, and H2 Database.
3. **Create Application Properties**  
   Configure database connection settings.
4. **Define Entities and Repositories**  
   Implement the `Book` entity and `BookRepository` interface.
5. **Create a REST Controller**  
   Implement `BookController` for CRUD operations.
6. **Run the Application**  
   Start the Spring Boot application and test the functionality.

## Notes

- Ensure you have Maven and Java installed for project management and running the application.
- Use SQL*Plus or a similar tool for executing PL/SQL scripts.
- Adjust paths and file names based on your development environment.

