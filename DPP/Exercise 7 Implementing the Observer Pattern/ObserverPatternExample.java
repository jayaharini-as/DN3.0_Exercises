// File: ObserverPatternExample.java

import java.util.ArrayList;
import java.util.List;

// Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject Class
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double newPrice) {
        this.stockPrice = newPrice;
        System.out.println("📈 Stock price updated to: $" + stockPrice);
        notifyObservers();
    }
}

// Observer Interface
interface Observer {
    void update(double stockPrice);
}

// Concrete Observer Class: MobileApp
class MobileApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("📱 MobileApp Notification: Stock price is now $" + stockPrice);
    }
}

// Concrete Observer Class: WebApp
class WebApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("💻 WebApp Notification: Stock price is now $" + stockPrice);
    }
}

// Test Class
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Introduction
        System.out.println("📊 Welcome to the Stock Market Monitoring Application! 📊");
        System.out.println("============================================");

        // Create stock market (subject) and observers
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Simulate stock price updates
        System.out.println("\n🚀 Simulating Stock Price Changes:");
        stockMarket.setStockPrice(123.45); // Notify observers

        System.out.println();
        stockMarket.setStockPrice(130.67); // Notify observers

        System.out.println();
        stockMarket.setStockPrice(115.89); // Notify observers

        // End message
        System.out.println("\nThank you for using the Stock Market Monitoring Application!");
        System.out.println("============================================");
    }
}
