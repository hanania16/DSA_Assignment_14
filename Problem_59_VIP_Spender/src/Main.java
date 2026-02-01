import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VIPSpenderTracker tracker = new VIPSpenderTracker();
        Scanner sc = new Scanner(System.in);

        System.out.println("VIP Spender Tracker Started");
        System.out.println("Commands:");
        System.out.println("PURCHASE <user> <amount>");
        System.out.println("SHOW_VIP");
        System.out.println("EXIT");

        while (true) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");

            if (parts[0].equalsIgnoreCase("PURCHASE")) {
                String user = parts[1];
                int amount = Integer.parseInt(parts[2]);
                tracker.purchase(user, amount);
            }
            else if (parts[0].equalsIgnoreCase("SHOW_VIP")) {
                tracker.showVIP();
            }
            else if (parts[0].equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting...");
                break;
            }
            else {
                System.out.println("Invalid Command");
            }
        }

        sc.close();
    }
}
