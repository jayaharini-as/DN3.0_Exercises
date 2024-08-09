-- Scenario 1: Process monthly interest for all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
    
    COMMIT;
END;
/

-- Scenario 2: Implement a bonus scheme for employees based on department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE Department = p_department;
    
    COMMIT;
END;
/

-- Scenario 3: Transfer funds between accounts
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    -- Check balance of source account
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;

    -- Perform the transfer
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;
    
    COMMIT;
END;
/
