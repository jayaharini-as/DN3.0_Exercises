// File: SingletonTest.java

public class SingletonTest {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        // Check if both references point to the same instance
        System.out.println("\nChecking Singleton Pattern...");
        System.out.println("Are both logger instances the same? " + (logger1 == logger2));
        
        // Display instance status
        logger1.displayInstanceStatus();
        
        // Use the logger instance to log messages
        System.out.println("\nLogging Messages...");
        logger1.log("This is a regular log message.");
        logger2.logError("This is an error message.");
        
        System.out.println("\nTest completed.");
    }
}
