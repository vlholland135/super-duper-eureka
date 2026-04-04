import java.util.Scanner;

public class TestCustomerAccountApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        System.out.println("Welcome to the Customer Account App");

        // Prompt for customer ID
        System.out.println("\nEnter a customer ID:");
        System.out.print("  ex: 1007, 1008, 1009>: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Customer customer = CustomerDB.getCustomer(id);

        String choice;

        // do...while loop to keep menu running
        do {
            account.displayMenu();
            String option = scanner.nextLine().trim();

            if (option.equalsIgnoreCase("D")) {
                System.out.print("Enter deposit amount: ");
                double amt = scanner.nextDouble();
                scanner.nextLine();
                account.deposit(amt);
            } else if (option.equalsIgnoreCase("W")) {
                System.out.print("Enter withdraw amount: ");
                double amt = scanner.nextDouble();
                scanner.nextLine();
                account.withdraw(amt);
            } else if (option.equalsIgnoreCase("B")) {
                System.out.printf("Account balance: $%,6.2f%n", account.getBalance());
            } else {
                System.out.println("Error: Invalid option");
            }

            System.out.print("\nContinue? (y/n): ");
            choice = scanner.nextLine().trim();

        } while (choice.equalsIgnoreCase("y"));

        // Display customer details and final balance
        System.out.println("\n" + customer.toString());
        System.out.printf("%nBalance as of %s is $%,6.2f%n",
                account.getTransactionDate(), account.getBalance());
        System.out.println("\nEnd of line...");

        scanner.close();
    }
}
