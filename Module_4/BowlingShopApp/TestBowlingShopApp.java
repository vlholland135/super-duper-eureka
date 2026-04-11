import java.util.Scanner;

public class TestBowlingShopApp {

    public static void displayMenu() {
        System.out.println("MENU OPTIONS");
        System.out.println("   1. <b> Bowling Balls");
        System.out.println("   2. <a> Bowling Bags");
        System.out.println("   3. <s> Bowling Shoes");
        System.out.println("   4. <x> To exit");
        System.out.print("\nPlease choose an option: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bowling Shop\n");

        String choice = "";

        do {
            displayMenu();
            choice = scanner.nextLine().trim();

            if (!choice.equalsIgnoreCase("x")) {
                GenericQueue<Product> products = ProductDB.getProducts(choice);

                if (products.size() == 0) {
                    System.out.println("\nError: Invalid option\n");
                } else {
                    System.out.println("\n--Product Listing--");
                    while (products.size() > 0) {
                        System.out.println(products.dequeue().toString());
                        System.out.println();
                    }
                }
            }

        } while (!choice.equalsIgnoreCase("x"));

        System.out.println("End of line...");
        scanner.close();
    }
}
