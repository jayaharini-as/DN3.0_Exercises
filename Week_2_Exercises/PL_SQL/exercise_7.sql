-- Scenario 1: Customer Management Package
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer (
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE,
        p_balance IN NUMBER
    );
    
    PROCEDURE UpdateCustomerDetails (
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_balance IN NUMBER
    );
    
    FUNCTION GetCustomerBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddNewCustomer (
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE,
        p_balance IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);
        COMMIT;
    END;
    
    PROCEDURE UpdateCustomerDetails (
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_balance IN NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name, Balance = p_balance, LastModified = SYSDATE
        WHERE CustomerID = p_customer_id;
        COMMIT;
    END;
    
    FUNCTION GetCustomerBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_customer_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END;
END CustomerManagement;
/

-- Scenario 2: Employee Management Package
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireNewEmployee (
        p_employee_id IN NUMBER,
        p_name IN VARCHAR2,
        p_position IN VARCHAR2,
        p_salary IN NUMBER,
        p_department IN VARCHAR2,
        p_hire_date IN DATE
    );
    
    PROCEDURE UpdateEmployeeDetails (
        p_employee_id IN NUMBER,
        p_name IN VARCHAR2,
        p_salary IN NUMBER,
        p_position IN VARCHAR2
    );
    
    FUNCTION CalculateAnnualSalary (
        p_employee_id IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireNewEmployee (
        p_employee_id IN NUMBER,
        p_name IN VARCHAR2,
        p_position IN VARCHAR2,
        p_salary IN NUMBER,
        p_department IN VARCHAR2,
        p_hire_date IN DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employee_id, p_name, p_position, p_salary, p_department, p_hire_date);
        COMMIT;
    END;
    
    PROCEDURE UpdateEmployeeDetails (
        p_employee_id IN NUMBER,
        p_name IN VARCHAR2,
        p_salary IN NUMBER,
        p_position IN VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name, Salary = p_salary, Position = p_position
        WHERE EmployeeID = p_employee_id;
        COMMIT;
    END;
    
    FUNCTION CalculateAnnualSalary (
        p_employee_id IN NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_employee_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END;
END EmployeeManagement;
/

-- Scenario 3: Account Operations Package
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenNewAccount (
        p_account_id IN NUMBER,
        p_customer_id IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance IN NUMBER
    );
    
    PROCEDURE CloseAccount (
        p_account_id IN NUMBER
    );
    
    FUNCTION GetTotalBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenNewAccount (
        p_account_id IN NUMBER,
        p_customer_id IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_account_type, p_balance, SYSDATE);
        COMMIT;
    END;
    
    PROCEDURE CloseAccount (
        p_account_id IN NUMBER
    ) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_account_id;
        COMMIT;
    END;
    
    FUNCTION GetTotalBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_total_balance NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total_balance
        FROM Accounts
        WHERE CustomerID = p_customer_id;
        RETURN v_total_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END;
END AccountOperations;
/
