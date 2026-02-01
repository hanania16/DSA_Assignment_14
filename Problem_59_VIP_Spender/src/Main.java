import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VIPTracker tracker = new VIPTracker();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String command = sc.next();

            if (command.equalsIgnoreCase("PURCHASE")) {
                String user = sc.next();
                int amount = sc.nextInt();
                tracker.purchase(user, amount);

            } else if (command.equalsIgnoreCase("SHOW_VIP")) {
                tracker.showVIP();

            } else if (command.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting VIP Tracker...");
                break;

            } else {
                System.out.println("Invalid command.");
            }
        }

        sc.close();
    }
}
