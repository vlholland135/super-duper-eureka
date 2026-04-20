import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {

    public static String menu() {
        return "\nMENU OPTIONS\n" +
               "   1. View Transactions\n" +
               "   2. Add Transactions\n" +
               "   3. View Expense\n" +
               "\nPlease choose an option: ";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueChoice = "y";

        System.out.println("Welcome to the Expense Tracker");

        while (continueChoice.equalsIgnoreCase("y")) {
            int input = ValidatorIO.getInt(sc, menu());

            if (input == 1) {
                System.out.println("\nMONTHLY EXPENSES\n");
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll();
                    for (Transaction t : transactions) {
                        System.out.println("Date: " + t.getDate());
                        System.out.println("Description: " + t.getDescription());
                        System.out.printf("Amount: $%,6.2f%n", t.getAmount());
                        System.out.println();
                    }
                } catch (IOException e) {
                    System.out.println("\n  Exception: " + e.getMessage());
                }

            } else if (input == 2) {
                String c = "y";
                ArrayList<Transaction> transactions = new ArrayList<>();

                while (c.equalsIgnoreCase("y")) {
                    String description = ValidatorIO.getString(sc, "\n  Enter the description: ");
                    double amount = ValidatorIO.getDouble(sc, "  Enter the amount: ");

                    Transaction transaction = new Transaction(description, amount);
                    transactions.add(transaction);

                    c = ValidatorIO.getString(sc, "\n  Add another transaction? (y/n): ");
                }

                try {
                    TransactionIO.bulkInsert(transactions);
                } catch (IOException e) {
                    System.out.println("\n  Exception: " + e.getMessage());
                }

            } else if (input == 3) {
                double monthlyExpense = 0;
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll();
                    for (Transaction transaction : transactions) {
                        monthlyExpense += transaction.getAmount();
                    }
                    System.out.printf("%nYour total monthly expense is $%,.2f%n", monthlyExpense);
                } catch (IOException e) {
                    System.out.println("\n  Exception: " + e.getMessage());
                }

            } else {
                System.out.println("\n  Invalid option. Please select 1, 2, or 3.");
            }

            continueChoice = ValidatorIO.getString(sc, "\nContinue? (y/n): ");
        }

        System.out.println("\nProgram terminated by the user...");
        sc.close();
    }
}
