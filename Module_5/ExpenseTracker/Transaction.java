import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String date;
    private String description;
    private double amount;

    // No-argument constructor
    public Transaction() {
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        this.description = "";
        this.amount = 0;
    }

    // Argument constructor
    public Transaction(String description, double amount) {
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        this.description = description;
        this.amount = amount;
    }

    // Full argument constructor
    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    // Accessors
    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    // Mutators
    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\n" +
               "Description: " + description + "\n" +
               "Amount: " + amount;
    }
}
