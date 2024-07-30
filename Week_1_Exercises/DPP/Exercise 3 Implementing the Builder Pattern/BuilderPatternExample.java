// File: BuilderPatternExample.java

import java.util.Scanner;

public class BuilderPatternExample {

    // Product class
    public static class Computer {
        // Required parameters
        private final String CPU;
        private final int RAM;
        
        // Optional parameters
        private final int storage;
        private final boolean hasGraphicsCard;
        private final boolean hasBluetooth;

        // Private constructor to be used by the Builder
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.hasGraphicsCard = builder.hasGraphicsCard;
            this.hasBluetooth = builder.hasBluetooth;
        }

        // Static nested Builder class
        public static class Builder {
            // Required parameters
            private final String CPU;
            private final int RAM;
            
            // Optional parameters with default values
            private int storage = 0;
            private boolean hasGraphicsCard = false;
            private boolean hasBluetooth = false;

            // Builder constructor with required parameters
            public Builder(String CPU, int RAM) {
                this.CPU = CPU;
                this.RAM = RAM;
            }

            // Setter methods for optional parameters
            public Builder setStorage(int storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(boolean hasGraphicsCard) {
                this.hasGraphicsCard = hasGraphicsCard;
                return this;
            }

            public Builder setBluetooth(boolean hasBluetooth) {
                this.hasBluetooth = hasBluetooth;
                return this;
            }

            // Build method to construct the Computer instance
            public Computer build() {
                return new Computer(this);
            }
        }

        @Override
        public String toString() {
            return String.format(
                "\n==============================\n" +
                "📈 Computer Specifications:\n" +
                "------------------------------\n" +
                "CPU                : %s\n" +
                "RAM                : %d GB\n" +
                "Storage            : %d GB\n" +
                "Graphics Card      : %s\n" +
                "Bluetooth Enabled  : %s\n" +
                "==============================\n",
                CPU, RAM, storage, 
                hasGraphicsCard ? "Yes" : "No",
                hasBluetooth ? "Yes" : "No"
            );
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introduction message
        System.out.println("Welcome to the Computer Builder System!");
        System.out.println("=========================================");

        // Display predefined configurations
        System.out.println("Select a predefined configuration:");
        System.out.println("1. Basic Office PC");
        System.out.println("2. Gaming PC");
        System.out.println("3. High-End Workstation");
        System.out.println("4. Custom Build");
        System.out.print("Enter your choice (1-4): ");
        int choice = Integer.parseInt(scanner.nextLine());

        Computer.Builder builder = null;

        switch (choice) {
            case 1:
                // Basic Office PC
                builder = new Computer.Builder("Intel i3", 4)
                        .setStorage(256)
                        .setGraphicsCard(false)
                        .setBluetooth(true);
                System.out.println("\nSelected: Basic Office PC");
                break;

            case 2:
                // Gaming PC
                builder = new Computer.Builder("Intel i7", 16)
                        .setStorage(1024)
                        .setGraphicsCard(true)
                        .setBluetooth(true);
                System.out.println("\nSelected: Gaming PC");
                break;

            case 3:
                // High-End Workstation
                builder = new Computer.Builder("AMD Ryzen 9", 32)
                        .setStorage(2048)
                        .setGraphicsCard(true)
                        .setBluetooth(true);
                System.out.println("\nSelected: High-End Workstation");
                break;

            case 4:
                // Custom Build
                System.out.print("Enter CPU model: ");
                String cpu = scanner.nextLine();
                System.out.print("Enter RAM size (in GB): ");
                int ram = Integer.parseInt(scanner.nextLine());

                builder = new Computer.Builder(cpu, ram);
                System.out.println("\nSelected: Custom Build");
                break;

            default:
                System.out.println("Invalid choice. Exiting.");
                scanner.close();
                return;
        }

        boolean continueInput = true;
        while (continueInput) {
            System.out.println("\n🔧 Configure your computer:");
            System.out.println("1. Update Storage");
            System.out.println("2. Add/Remove Graphics Card");
            System.out.println("3. Enable/Disable Bluetooth");
            System.out.println("4. Display Current Configuration");
            System.out.println("5. Finalize and Exit");
            System.out.print("Enter your choice (1-5): ");
            int configChoice = Integer.parseInt(scanner.nextLine());

            switch (configChoice) {
                case 1:
                    System.out.print("Enter storage size (in GB): ");
                    int storage = Integer.parseInt(scanner.nextLine());
                    builder.setStorage(storage);
                    System.out.println("Storage updated to " + storage + " GB.");
                    break;
                
                case 2:
                    System.out.print("Do you want to add a graphics card? (yes/no): ");
                    String graphicsCardInput = scanner.nextLine();
                    boolean hasGraphicsCard = graphicsCardInput.equalsIgnoreCase("yes");
                    builder.setGraphicsCard(hasGraphicsCard);
                    System.out.println("Graphics card configuration updated.");
                    break;

                case 3:
                    System.out.print("Do you want to enable Bluetooth? (yes/no): ");
                    String bluetoothInput = scanner.nextLine();
                    boolean hasBluetooth = bluetoothInput.equalsIgnoreCase("yes");
                    builder.setBluetooth(hasBluetooth);
                    System.out.println("Bluetooth configuration updated.");
                    break;

                case 4:
                    Computer computer = builder.build();
                    System.out.println("Current Computer Configuration:");
                    System.out.println(computer);
                    break;

                case 5:
                    continueInput = false;
                    System.out.println("Thank you for using the Computer Builder System!");
                    System.out.println("Your final configuration is:");
                    Computer finalComputer = builder.build();
                    System.out.println(finalComputer);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}
