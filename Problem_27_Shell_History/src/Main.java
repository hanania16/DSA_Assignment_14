import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HistoryIterator history = new HistoryIterator();
        CommandParser parser = new CommandParser(history);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Shell Command History Simulator ===");
            System.out.println("1. EXEC <command>");
            System.out.println("2. HISTORY (Show last 10 commands)");
            System.out.println("3. BANG_LAST (!!)");
            System.out.println("4. BANG_PREFIX (!prefix)");
            System.out.println("5. UP (Navigate up in history)");
            System.out.println("6. DOWN (Navigate down in history)");
            System.out.println("7. EXIT");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter command to execute: ");
                    String cmd = sc.nextLine().trim();
                    parser.execute(cmd);
                    break;

                case "2":
                    parser.showHistory();
                    break;

                case "3":
                    parser.bangLast();
                    break;

                case "4":
                    System.out.print("Enter prefix: ");
                    String prefix = sc.nextLine().trim();
                    parser.bangPrefix(prefix);
                    break;

                case "5":
                    parser.navigateUp();
                    break;

                case "6":
                    parser.navigateDown();
                    break;

                case "7":
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
