import java.util.Scanner;

public class FinancialForecasting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the menu
            System.out.println("\nFinancial Forecasting Tool");
            System.out.println("Choose an option:");
            System.out.println("1. Calculate with static values");
            System.out.println("2. Calculate with dynamic input");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1/2/3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Static values calculation
                    double staticInitialValue = 1000.0;
                    double staticGrowthRate = 0.05; // 5%
                    int staticPeriods = 10;

                    System.out.println("Calculating with static values...");
                    double staticFutureValueRecursive = calculateFutureValueRecursive(staticInitialValue, staticGrowthRate, staticPeriods);
                    double staticFutureValueIterative = calculateFutureValueIterative(staticInitialValue, staticGrowthRate, staticPeriods);

                    System.out.printf("Recursive Approach: The forecasted value after %d periods is: %.2f\n", staticPeriods, staticFutureValueRecursive);
                    System.out.printf("Iterative Approach: The forecasted value after %d periods is: %.2f\n", staticPeriods, staticFutureValueIterative);
                    break;

                case 2:
                    // Dynamic input calculation
                    System.out.print("Enter the initial value: ");
                    double dynamicInitialValue = scanner.nextDouble();
                    System.out.print("Enter the growth rate (as a decimal, e.g., 0.05 for 5%): ");
                    double dynamicGrowthRate = scanner.nextDouble();
                    System.out.print("Enter the number of periods: ");
                    int dynamicPeriods = scanner.nextInt();

                    System.out.println("Calculating with dynamic values...");
                    double dynamicFutureValueRecursive = calculateFutureValueRecursive(dynamicInitialValue, dynamicGrowthRate, dynamicPeriods);
                    double dynamicFutureValueIterative = calculateFutureValueIterative(dynamicInitialValue, dynamicGrowthRate, dynamicPeriods);

                    System.out.printf("Recursive Approach: The forecasted value after %d periods is: %.2f\n", dynamicPeriods, dynamicFutureValueRecursive);
                    System.out.printf("Iterative Approach: The forecasted value after %d periods is: %.2f\n", dynamicPeriods, dynamicFutureValueIterative);
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Exiting the Financial Forecasting Tool. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                    break;
            }
        } while (choice != 3); // Continue the loop until the user chooses to exit

        scanner.close();
    }

    /**
     * Calculates the future value using a recursive approach.
     *
     * @param currentValue  The current value to forecast from
     * @param growthRate    The growth rate as a decimal (e.g., 0.05 for 5%)
     * @param periods       The number of periods to forecast
     * @return              The future value after the given number of periods
     */
    public static double calculateFutureValueRecursive(double currentValue, double growthRate, int periods) {
        // Base case: if there are no more periods, return the current value
        if (periods == 0) {
            return currentValue;
        }
        // Recursive case: calculate future value for the next period
        return calculateFutureValueRecursive(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    /**
     * Calculates the future value using an iterative approach.
     *
     * @param initialValue  The initial value to forecast from
     * @param growthRate    The growth rate as a decimal (e.g., 0.05 for 5%)
     * @param periods       The number of periods to forecast
     * @return              The future value after the given number of periods
     */
    public static double calculateFutureValueIterative(double initialValue, double growthRate, int periods) {
        double futureValue = initialValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }
}
