// File: Logger.java

public class Logger {
    // The single instance of Logger
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialization code, if necessary
        System.out.println("Logger instance created.");
    }

    // Public static method to provide access to the instance
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages with a timestamp
    public void log(String message) {
        String timestamp = java.time.LocalDateTime.now().toString();
        System.out.println("[" + timestamp + "] " + message);
    }

    // Method to log errors
    public void logError(String errorMessage) {
        String timestamp = java.time.LocalDateTime.now().toString();
        System.err.println("[" + timestamp + "] ERROR: " + errorMessage);
    }
    
    // Method to display the class name and instance status
    public void displayInstanceStatus() {
        System.out.println("Current instance class: " + instance.getClass().getSimpleName());
        System.out.println("Is instance initialized: " + (instance != null));
    }
}
