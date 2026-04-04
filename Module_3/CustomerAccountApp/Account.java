import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Account {

    private double balance = 200;

    // Accessor
    public double getBalance() { return balance; }

    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
        }
    }

    public void displayMenu() {
        System.out.println("\nAccount Menu");
        System.out.println("Enter <D/d> for deposit");
        System.out.println("Enter <W/w> for withdraw");
        System.out.println("Enter <B/b> for balance");
        System.out.print("  Enter option>: ");
    }

    public String getTransactionDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return today.format(formatter);
    }
}
