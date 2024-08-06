import java.util.Scanner;

// Command Interface
interface Command {
    void execute();
}

// Receiver Class
class Light {
    public void turnOn() {
        System.out.println("💡 The light is ON.");
    }

    public void turnOff() {
        System.out.println("💡 The light is OFF.");
    }
}

// Concrete Command: LightOnCommand
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command: LightOffCommand
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker Class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Test Class
public class CommandPatternExample {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🏠 Home Automation System 🏠");
        System.out.println("==========================");
        System.out.println("1. Turn Light ON");
        System.out.println("2. Turn Light OFF");
        System.out.println("0. Exit");

        boolean running = true;
        while (running) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    remote.setCommand(lightOn);
                    remote.pressButton();
                    break;

                case 2:
                    remote.setCommand(lightOff);
                    remote.pressButton();
                    break;

                case 0:
                    System.out.println("Exiting Home Automation System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 0.");
                    break;
            }
        }

        scanner.close();
    }
}
