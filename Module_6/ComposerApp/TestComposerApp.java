import java.util.List;
import java.util.Scanner;

/**
 * TestComposerApp.java
 *
 * The main application class for the Composer App. This class serves as the
 * entry point and provides an interactive console menu allowing users to view
 * all composers, find a composer by id, or add a new composer to the data store.
 * It exercises the Composer and MemComposerDao classes through the ComposerDao interface.
 *
 * @author Holland, Victoria
 * @version 1.0
 * @since 2026
 */
public class TestComposerApp {

    /**
     * The main method that launches the Composer App and drives the menu loop.
     * Continues prompting the user until option 4 (Exit) is selected.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Instantiate the in-memory DAO and Scanner for user input
        ComposerDao dao = new MemComposerDao();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Composer App");

        int choice = 0;

        // Main application loop — runs until the user selects Exit
        while (choice != 4) {

            // Display menu options
            System.out.println("\n  MENU OPTIONS");
            System.out.println("    1. View Composers");
            System.out.println("    2. Find Composer");
            System.out.println("    3. Add Composer");
            System.out.println("    4. Exit");
            System.out.print("\n  Please choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {

                case 1:
                    // Display all composers using findAll()
                    System.out.println("\n  --DISPLAYING COMPOSERS--");
                    List<Composer> allComposers = dao.findAll();
                    for (Composer c : allComposers) {
                        System.out.println(c);
                        System.out.println();
                    }
                    break;

                case 2:
                    // Find a single composer by id using findBy()
                    System.out.print("  Enter an id: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    Composer found = dao.findBy(searchId);
                    System.out.println("\n  --DISPLAYING COMPOSER--");
                    if (found != null) {
                        System.out.println(found);
                        System.out.println();
                    } else {
                        System.out.println("  No composer found with id: " + searchId);
                    }
                    break;

                case 3:
                    // Collect input and insert a new composer using insert()
                    System.out.print("  Enter an id: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.print("  Enter a name: ");
                    String newName = scanner.nextLine();

                    System.out.print("  Enter a genre: ");
                    String newGenre = scanner.nextLine();

                    dao.insert(new Composer(newId, newName, newGenre));
                    System.out.println("\n  Composer added successfully.");
                    break;

                case 4:
                    // Exit message
                    System.out.println("\n  Exiting the Composer App. Goodbye!");
                    break;

                default:
                    System.out.println("\n  Invalid option. Please enter 1, 2, 3, or 4.");
            }
        }

        scanner.close();
    }
}
