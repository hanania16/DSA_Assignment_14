public class CommandParser {
    private HistoryIterator history;

    public CommandParser(HistoryIterator history) {
        this.history = history;
    }

    // Execute a normal command
    public void execute(String cmd) {
        history.addCommand(cmd);
        System.out.println("Executed: " + cmd);
    }

    // Execute last command (!!)
    public void bangLast() {
        String cmd = history.getLastCommand();
        if (cmd == null) {
            System.out.println("No commands in history.");
            return;
        }
        System.out.println("Found \"" + cmd + "\". Executing...");
        execute(cmd);
    }

    // Execute command by prefix (!prefix)
    public void bangPrefix(String prefix) {
        String cmd = history.getCommandByPrefix(prefix);
        if (cmd == null) {
            System.out.println("No command found with prefix: " + prefix);
            return;
        }
        System.out.println("Found \"" + cmd + "\". Executing...");
        execute(cmd);
    }

    // Navigate UP
    public void navigateUp() {
        String cmd = history.navigateUp();
        if (cmd != null) {
            System.out.println("Previous: " + cmd);
        }
    }

    // Navigate DOWN
    public void navigateDown() {
        String cmd = history.navigateDown();
        if (cmd != null) {
            System.out.println("Next: " + cmd);
        }
    }

    // Show history
    public void showHistory() {
        history.showHistory();
    }
}
