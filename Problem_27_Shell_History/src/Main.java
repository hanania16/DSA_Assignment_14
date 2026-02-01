import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HistoryIterator history = new HistoryIterator();
        CommandParser parser = new CommandParser(history);
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Shell Command History Simulator ===");
        System.out.println("Type commands directly:");
        System.out.println("- Normal command: any string");
        System.out.println("- !! : execute last command");
        System.out.println("- !N : execute command #N");
        System.out.println("- !prefix : execute most recent command starting with prefix");
        System.out.println("- history : show last 10 commands");
        System.out.println("- UP / DOWN : navigate through history");
        System.out.println("- exit : exit shell\n");

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }
            parser.parseAndExecute(input);
        }

        sc.close();
    }
}
