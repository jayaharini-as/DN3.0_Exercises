// File: ProxyPatternExample.java

// Subject Interface
interface Image {
    void display();
}

// Real Subject Class
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image: " + filename + " from server...");
        try {
            // Simulating time-consuming task
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy Class
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Test Class
public class ProxyPatternExample {
    public static void main(String[] args) {
        // Introduction
        System.out.println("🎨 Welcome to the Image Viewer Application! 🎨");
        System.out.println("============================================");

        // Create proxy images
        Image image1 = new ProxyImage("beach.jpg");
        Image image2 = new ProxyImage("mountain.jpg");
        Image image3 = new ProxyImage("forest.jpg");

        // Display images
        System.out.println("🚀 Displaying Image 1:");
        image1.display(); // This will load the image from the server
        System.out.println();

        System.out.println("🚀 Displaying Image 2:");
        image2.display(); // This will load the image from the server
        System.out.println();

        System.out.println("🚀 Displaying Image 1 Again:");
        image1.display(); // This will use the cached image
        System.out.println();

        System.out.println("🚀 Displaying Image 3:");
        image3.display(); // This will load the image from the server
        System.out.println();

        // End message
        System.out.println("Thank you for using the Image Viewer Application!");
        System.out.println("============================================");
    }
}
