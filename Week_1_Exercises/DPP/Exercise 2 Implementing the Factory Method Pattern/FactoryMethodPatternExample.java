// File: FactoryMethodPatternExample.java

import java.util.Scanner;

// Document interface
interface Document {
    void create();
}

// Concrete Document classes
class WordDocument implements Document {
    @Override
    public void create() {
        System.out.println("======================================");
        System.out.println("📄 Creating a Word document.");
        System.out.println("======================================");
    }
}

class PdfDocument implements Document {
    @Override
    public void create() {
        System.out.println("======================================");
        System.out.println("📄 Creating a PDF document.");
        System.out.println("======================================");
    }
}

class ExcelDocument implements Document {
    @Override
    public void create() {
        System.out.println("======================================");
        System.out.println("📄 Creating an Excel document.");
        System.out.println("======================================");
    }
}

// DocumentFactory abstract class
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Concrete DocumentFactory classes
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Test class with switch case
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Document Management System!");
        System.out.println("=========================================");
        System.out.println("Select the type of document to create:");
        System.out.println("1. Word Document");
        System.out.println("2. PDF Document");
        System.out.println("3. Excel Document");
        System.out.println("Enter your choice (1-3):");
        
        int choice = scanner.nextInt();
        DocumentFactory factory;
        Document document;
        
        switch (choice) {
            case 1:
                factory = new WordDocumentFactory();
                document = factory.createDocument();
                document.create();
                break;
            case 2:
                factory = new PdfDocumentFactory();
                document = factory.createDocument();
                document.create();
                break;
            case 3:
                factory = new ExcelDocumentFactory();
                document = factory.createDocument();
                document.create();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }

        System.out.println("=========================================");
        System.out.println("Document creation process completed.");
        scanner.close();
    }
}
