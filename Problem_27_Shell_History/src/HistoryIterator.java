import java.util.ArrayList;
import java.util.List;

public class HistoryIterator {
    private List<String> history;
    private int pointer; // For navigation

    public HistoryIterator() {
        history = new ArrayList<>();
        pointer = history.size(); // Start pointer at the end
    }

    public void addCommand(String cmd) {
        if (history.isEmpty() || !history.get(history.size() - 1).equals(cmd)) {
            history.add(cmd);
        } else {
            System.out.println("Ignored duplicate (same as prev).");
        }
        pointer = history.size(); // Reset pointer after execution
    }

    public String getLastCommand() {
        if (history.isEmpty()) return null;
        return history.get(history.size() - 1);
    }

    public String getCommandByIndex(int index) {
        if (index < 1 || index > history.size()) return null;
        return history.get(index - 1);
    }

    public String getCommandByPrefix(String prefix) {
        for (int i = history.size() - 1; i >= 0; i--) {
            if (history.get(i).startsWith(prefix)) return history.get(i);
        }
        return null;
    }

    public void showHistory() {
        System.out.println("----- Last Commands -----");
        int start = Math.max(0, history.size() - 10);
        for (int i = start; i < history.size(); i++) {
            System.out.println((i + 1) + ": " + history.get(i));
        }
        System.out.println("-------------------------");
    }

    public String navigateUp() {
        if (history.isEmpty() || pointer <= 0) {
            System.out.println("No older commands.");
            return null;
        }
        pointer--;
        return history.get(pointer);
    }

    public String navigateDown() {
        if (history.isEmpty() || pointer >= history.size() - 1) {
            System.out.println("No newer commands.");
            return null;
        }
        pointer++;
        return history.get(pointer);
    }
}
