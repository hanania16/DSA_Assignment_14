import java.util.ArrayList;

public class HistoryManager {

    private ArrayList<String> history;

    public HistoryManager() {
        history = new ArrayList<>();
    }

    // EXEC <cmd>
    public void executeCommand(String cmd) {
        if (history.isEmpty()) {
            history.add(cmd);
            return;
        }

        String lastCmd = history.get(history.size() - 1);
        if (!lastCmd.equals(cmd)) {
            history.add(cmd);
        } else {
            System.out.println("Ignored duplicate (same as prev).");
        }
    }

    // !!  → last command
    public String getLastCommand() {
        if (history.isEmpty()) return null;
        return history.get(history.size() - 1);
    }

    // !prefix → most recent match
    public String getCommandByPrefix(String prefix) {
        for (int i = history.size() - 1; i >= 0; i--) {
            if (history.get(i).startsWith(prefix)) {
                return history.get(i);
            }
        }
        return null;
    }

    // !N → command by index (1-based)
    public String getCommandByIndex(int index) {
        if (index < 1 || index > history.size()) return null;
        return history.get(index - 1);
    }

    // HISTORY (last 10)
    public void printHistory() {
        int start = Math.max(0, history.size() - 10);
        for (int i = start; i < history.size(); i++) {
            System.out.println((i + 1) + ": " + history.get(i));
        }
    }

    public int size() {
        return history.size();
    }

    public String get(int i) {
        return history.get(i);
    }
}