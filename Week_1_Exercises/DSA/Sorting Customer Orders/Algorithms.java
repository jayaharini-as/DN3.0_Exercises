// File: Algorithms.java

import java.util.ArrayList;

public class Algorithms {

    // Bubble Sort Implementation
    public static void bubbleSort(ArrayList<Main.Order> orders) {
        int n = orders.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders.get(j).getTotalPrice() > orders.get(j + 1).getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Main.Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }

    // Quick Sort Implementation
    public static void quickSort(ArrayList<Main.Order> orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(ArrayList<Main.Order> orders, int low, int high) {
        double pivot = orders.get(high).getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders.get(j).getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Main.Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }
        // Swap orders[i + 1] and orders[high]
        Main.Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);

        return i + 1;
    }
}
