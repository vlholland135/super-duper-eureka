/**
 * Holland, Victoria
 * CIS 505 - Intermediate Java Programming
 * Bellevue University
 * Assignment 8.2 - FinanceCalculator
 *
 * This class provides a static utility method for computing the future value
 * of a series of equal monthly payments at a compounding annual interest rate.
 * It is intended to be called from HollandEnhancedFutureValueApp without
 * instantiation, following a standard utility class pattern.
 */

public class FinanceCalculator {

    // Number of months in a calendar year used to derive the total payment
    // period from the user-supplied number of years.
    private static int MONTHS_IN_YEAR = 12;

    /**
     * Calculates the future value of a series of monthly payments compounded
     * at a given annual interest rate over a specified number of years.
     *
     * The interest rate multiplier follows Exhibit A: (1 + rate / 100).
     * The future value follows Exhibit B: presentValue * Math.pow(interestRate, months).
     *
     * @param monthlyPayment the fixed amount contributed each month
     * @param rate the annual interest rate as a percentage (e.g., 3.5 for 3.5%)
     * @param years the number of years the investment runs
     * @return the computed future value as a double
     */
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {

        // Total number of payment periods over the full investment term
        int months = years * MONTHS_IN_YEAR;

        // Exhibit A: convert the annual percentage rate into a compound multiplier
        double interestRate = (1 + rate / 100);

        // Present value represents the sum of all payments made over the term
        double presentValue = monthlyPayment * months;

        // Exhibit B: apply compound growth over the full number of months
        double futureValue = presentValue * (Math.pow(interestRate, months));

        return futureValue;
    }
}
