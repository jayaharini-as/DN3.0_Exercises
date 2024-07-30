// File: DecoratorPatternExample.java

// Component Interface
interface Notifier {
    void send(String message);
}

// Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("📧 Sending Email: " + message);
    }
}

// Abstract Decorator
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete Decorator for SMS
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the original notifier
        System.out.println("📱 Sending SMS: " + message);
    }
}

// Concrete Decorator for Slack
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the original notifier
        System.out.println("💬 Sending Slack Message: " + message);
    }
}

// Test Class
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Introduction
        System.out.println("🎉 Welcome to the Advanced Notification System! 🎉");
        System.out.println("============================================");

        // Create a basic email notifier
        Notifier emailNotifier = new EmailNotifier();
        
        // Decorate it with SMS and Slack functionality
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notifications
        System.out.println("\n🚀 Testing Full Notification Stack:");
        sendNotifications(slackNotifier, "Your order has been shipped!");

        System.out.println("\n🚀 Testing SMS Notification Only:");
        Notifier smsOnlyNotifier = new SMSNotifierDecorator(emailNotifier);
        sendNotifications(smsOnlyNotifier, "Important: Your account was accessed.");

        System.out.println("\n🚀 Testing Email Only Notification:");
        sendNotifications(emailNotifier, "Welcome to our service!");

        // End message
        System.out.println("\nThank you for using the Advanced Notification System!");
        System.out.println("============================================");
    }

    // Helper method to process and display notifications
    private static void sendNotifications(Notifier notifier, String message) {
        notifier.send(message);
        System.out.println("✔️ Notification successfully sent!\n");
    }
}
