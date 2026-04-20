import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {

    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);

    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;

        if (file.exists()) {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        } else {
            output = new PrintWriter(FILE_NAME);
        }

        for (Transaction tran : transactions) {
            output.print(tran.getDate() + " ");
            output.print(tran.getDescription() + " ");
            output.println(tran.getAmount());
        }

        output.close();
    }

    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String date = input.next();
            String description = input.next();
            double amount = input.nextDouble();

            Transaction t = new Transaction(date, description, amount);
            transactions.add(t);
        }

        input.close();
        return transactions;
    }
}
