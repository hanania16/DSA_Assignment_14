import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemoryManager manager = null;

        System.out.println("===== Memory Block Manager (Mark-Sweep Simulation) =====");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Set Heap Size");
            System.out.println("2. Allocate Block");
            System.out.println("3. Add Reference");
            System.out.println("4. Add Root");
            System.out.println("5. Remove Root");
            System.out.println("6. Run Garbage Collection (GC)");
            System.out.println("7. Show Heap Status");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter heap size: ");
                    int size = Integer.parseInt(sc.nextLine());
                    manager = new MemoryManager(size);
                    System.out.println("Heap size set to " + size);
                    break;

                case "2":
                    if (manager == null) {
                        System.out.println("Set heap size first!");
                        break;
                    }
                    System.out.print("Enter block ID to allocate: ");
                    String blockId = sc.nextLine().trim();
                    manager.alloc(blockId);
                    break;

                case "3":
                    if (manager == null) {
                        System.out.println("Set heap size first!");
                        break;
                    }
                    System.out.print("Enter FROM block ID: ");
                    String from = sc.nextLine().trim();
                    System.out.print("Enter TO block ID: ");
                    String to = sc.nextLine().trim();
                    manager.ref(from, to);
                    break;

                case "4":
                    if (manager == null) {
                        System.out.println("Set heap size first!");
                        break;
                    }
                    System.out.print("Enter block ID to add as root: ");
                    String rootId = sc.nextLine().trim();
                    manager.root(rootId);
                    break;

                case "5":
                    if (manager == null) {
                        System.out.println("Set heap size first!");
                        break;
                    }
                    System.out.print("Enter block ID to remove from roots: ");
                    String unrootId = sc.nextLine().trim();
                    manager.unroot(unrootId);
                    break;

                case "6":
                    if (manager == null) {
                        System.out.println("Set heap size first!");
                        break;
                    }
                    manager.gc();
                    break;

                case "7":
                    if (manager == null) {
                        System.out.println("Set heap size first!");
                        break;
                    }
                    manager.status();
                    break;

                case "8":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice! Please enter 1-8.");
            }
        }
    }
}
