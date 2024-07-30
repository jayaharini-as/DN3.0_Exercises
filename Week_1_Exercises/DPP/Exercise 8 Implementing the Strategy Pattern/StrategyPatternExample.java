// File: StrategyPatternExample.java

import java.util.Scanner;

// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy Class: CreditCardPayment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("💳 Paying $" + amount + " using Credit Card.");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Card Holder: " + cardHolderName);
    }
}

// Concrete Strategy Class: PayPalPayment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("💰 Paying $" + amount + " using PayPal.");
        System.out.println("PayPal Email: " + email);
    }
}

// Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("No payment strategy set.");
        }
    }
}

// Test Class
public class StrategyPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext paymentContext = new PaymentContext();

        System.out.println("💳 Welcome to the Payment System! 💳");
        System.out.println("============================================");

        while (true) {
            System.out.println("\nChoose Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting the Payment System. Thank you!");
                break;
            }

            System.out.println("Enter amount to pay:");
            double amount = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println("Enter Credit Card Number:");
                    String cardNumber = scanner.next();
                    System.out.println("Enter Card Holder Name:");
                    String cardHolderName = scanner.next();
                    PaymentStrategy creditCardPayment = new CreditCardPayment(cardNumber, cardHolderName);
                    paymentContext.setPaymentStrategy(creditCardPayment);
                    paymentContext.executePayment(amount);
                    break;
                case 2:
                    System.out.println("Enter PayPal Email:");
                    String email = scanner.next();
                    PaymentStrategy payPalPayment = new PayPalPayment(email);
                    paymentContext.setPaymentStrategy(payPalPayment);
                    paymentContext.executePayment(amount);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
