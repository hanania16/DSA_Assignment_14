import java.util.ArrayList;
import java.util.List;

public class HistoryIterator {
    private List<String> history;
    private int pointer; // For navigation

    public HistoryIterator() {
        history = new ArrayList<>();
        pointer = -1; // Start before first element
    }

    // Execute and store command with deduplication
    public void addCommand(String cmd) {
        if (history.isEmpty() || !history.get(history.size() - 1).equals(cmd)) {
            history.add(cmd);
        } else {
            System.out.println("Ignored duplicate (same as prev).");
        }
        pointer = history.size(); // Reset pointer after execution
    }

    // Show last 10 commands
    public void showHistory() {
        System.out.println("----- Last Commands -----");
        int start = Math.max(0, history.size() - 10);
        for (int i = start; i < history.size(); i++) {
            System.out.println((i + 1) + ": " + history.get(i));
        }
        System.out.println("-------------------------");
    }

    // Bang last command (!!)
    public String getLastCommand() {
        if (history.isEmpty()) {
            return null;
        }
        return history.get(history.size() - 1);
    }

    // Bang prefix (!prefix)
    public String getCommandByPrefix(String prefix) {
        for (int i = history.size() - 1; i >= 0; i--) {
            if (history.get(i).startsWith(prefix)) {
                return history.get(i);
            }
        }
        return null;
    }

    // Simulate UP navigation
    public String navigateUp() {
        if (history.isEmpty() || pointer <= 0) {
            System.out.println("No older commands.");
            return null;
        }
        pointer--;
        return history.get(pointer);
    }

    // Simulate DOWN navigation
    public String navigateDown() {
        if (history.isEmpty() || pointer >= history.size() - 1) {
            System.out.println("No newer commands.");
            return null;
        }
        pointer++;
        return history.get(pointer);
    }
}
