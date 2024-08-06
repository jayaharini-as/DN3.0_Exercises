// File: AdapterPatternExample.java

// Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee Class 1: PayPal Gateway
class PayPalPaymentGateway {
    void makePayment(double amount) {
        System.out.println("🌐 Processing payment of $" + amount + " through PayPal.");
    }
}

// Adaptee Class 2: Stripe Gateway
class StripePaymentGateway {
    void charge(double amount) {
        System.out.println("💳 Charging $" + amount + " using Stripe.");
    }
}

// Adapter for PayPal
class PayPalAdapter implements PaymentProcessor {
    private PayPalPaymentGateway payPalGateway;

    public PayPalAdapter() {
        this.payPalGateway = new PayPalPaymentGateway();
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}

// Adapter for Stripe
class StripeAdapter implements PaymentProcessor {
    private StripePaymentGateway stripeGateway;

    public StripeAdapter() {
        this.stripeGateway = new StripePaymentGateway();
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.charge(amount);
    }
}

// Test Class
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Introduction
        System.out.println("🎉 Welcome to the Payment Processing System! 🎉");
        System.out.println("============================================");

        // Create instances of the adapters
        PaymentProcessor payPalProcessor = new PayPalAdapter();
        PaymentProcessor stripeProcessor = new StripeAdapter();

        // Process payments using different gateways
        System.out.println("🚀 Testing PayPal Adapter:");
        processAndDisplayPayment(payPalProcessor, 120.50);

        System.out.println("\n🚀 Testing Stripe Adapter:");
        processAndDisplayPayment(stripeProcessor, 75.25);

        // End message
        System.out.println("\nThank you for using the Payment Processing System!");
        System.out.println("============================================");
    }

    // Helper method to process and display payment
    private static void processAndDisplayPayment(PaymentProcessor processor, double amount) {
        processor.processPayment(amount);
        System.out.println("✔️ Payment of $" + amount + " processed successfully!\n");
    }
}
