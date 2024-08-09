-- Scenario 1: Generate monthly statements for all customers
DECLARE
    CURSOR c_transactions IS
        SELECT * FROM Transactions
        WHERE EXTRACT(MONTH FROM TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
    
    v_account_id NUMBER;
BEGIN
    OPEN c_transactions;
    LOOP
        FETCH c_transactions INTO v_account_id;
        EXIT WHEN c_transactions%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Transaction ID: ' || v_account_id.TransactionID ||
                             ' Account ID: ' || v_account_id.AccountID ||
                             ' Amount: ' || v_account_id.Amount ||
                             ' Date: ' || v_account_id.TransactionDate);
    END LOOP;
    CLOSE c_transactions;
END;
/

-- Scenario 2: Apply annual fee to all accounts
DECLARE
    CURSOR c_accounts IS
        SELECT * FROM Accounts;
    
    v_fee NUMBER := 100; -- Annual maintenance fee
BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_account_id;
        EXIT WHEN c_accounts%NOTFOUND;
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = v_account_id.AccountID;
    END LOOP;
    CLOSE c_accounts;
    COMMIT;
END;
/

-- Scenario 3: Update the interest rate for all loans based on a new policy
DECLARE
    CURSOR c_loans IS
        SELECT * FROM Loans;
    
    v_new_interest_rate NUMBER := 6; -- New interest rate policy
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_loan_id;
        EXIT WHEN c_loans%NOTFOUND;
        UPDATE Loans
        SET InterestRate = v_new_interest_rate
        WHERE LoanID = v_loan_id.LoanID;
    END LOOP;
    CLOSE c_loans;
    COMMIT;
END;
/
