import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VIPSpenderTracker tracker = new VIPSpenderTracker();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== VIP Spender Tracker =====");
            System.out.println("1. Add Purchase");
            System.out.println("2. Show VIP Spenders");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    String user = sc.next();

                    System.out.print("Enter Amount: ");
                    int amount = sc.nextInt();

                    tracker.purchase(user, amount);
                    System.out.println("Purchase added successfully.");
                    break;

                case 2:
                    tracker.showVIP();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
