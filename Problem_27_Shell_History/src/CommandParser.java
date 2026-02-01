public class CommandParser {
    private HistoryIterator history;

    public CommandParser(HistoryIterator history) {
        this.history = history;
    }

    public void parseAndExecute(String input) {
        input = input.trim();

        if (input.equals("history")) {
            history.showHistory();
        } else if (input.equals("!!")) {
            String cmd = history.getLastCommand();
            if (cmd == null) {
                System.out.println("No commands in history.");
                return;
            }
            System.out.println("Found \"" + cmd + "\". Executing...");
            execute(cmd);
        } else if (input.startsWith("!")) {
            String arg = input.substring(1);
            // Check if number
            try {
                int index = Integer.parseInt(arg);
                String cmd = history.getCommandByIndex(index);
                if (cmd == null) {
                    System.out.println("No command found at index: " + index);
                    return;
                }
                System.out.println("Found \"" + cmd + "\". Executing...");
                execute(cmd);
            } catch (NumberFormatException e) {
                // Not a number → prefix
                String cmd = history.getCommandByPrefix(arg);
                if (cmd == null) {
                    System.out.println("No command found with prefix: " + arg);
                    return;
                }
                System.out.println("Found \"" + cmd + "\". Executing...");
                execute(cmd);
            }
        } else if (input.equalsIgnoreCase("UP")) {
            String cmd = history.navigateUp();
            if (cmd != null) System.out.println("Previous: " + cmd);
        } else if (input.equalsIgnoreCase("DOWN")) {
            String cmd = history.navigateDown();
            if (cmd != null) System.out.println("Next: " + cmd);
        } else if (!input.isEmpty()) {
            execute(input);
        }
    }

    private void execute(String cmd) {
        history.addCommand(cmd);
        System.out.println("Executed: " + cmd);
    }
}
