-- Scenario 1: Apply discount to loan interest rates for customers above 60 years old
DECLARE
    v_age NUMBER;
BEGIN
    FOR rec IN (SELECT CustomerID, DOB FROM Customers) LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Promote to VIP status based on balance
BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Send reminders for loans due in the next 30 days
DECLARE
    v_due_date NUMBER;
BEGIN
    FOR rec IN (SELECT CustomerID, LoanID, EndDate FROM Loans) LOOP
        v_due_date := rec.EndDate - SYSDATE;
        IF v_due_date <= 30 THEN
            DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID || ' for Customer ID ' || rec.CustomerID || ' is due in ' || v_due_date || ' days.');
        END IF;
    END LOOP;
END;
/
