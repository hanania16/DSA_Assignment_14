import java.util.*;

public class VIPTracker {

    private static final int K = 3;

    // User → Total Spend
    private Map<String, Integer> spendMap;

    // Min Heap to keep top K spenders
    private PriorityQueue<UserSpend> minHeap;

    public VIPTracker() {
        spendMap = new HashMap<>();
        minHeap = new PriorityQueue<>(Comparator.comparingInt(u -> u.total));
    }

    // PURCHASE <user> <amount>
    public void purchase(String user, int amount) {
        // Update total spend
        int newTotal = spendMap.getOrDefault(user, 0) + amount;
        spendMap.put(user, newTotal);

        // Remove old record from heap if exists
        minHeap.removeIf(u -> u.user.equals(user));

        // Add updated record
        minHeap.offer(new UserSpend(user, newTotal));

        // Keep only top K users
        if (minHeap.size() > K) {
            minHeap.poll();
        }
    }

    // SHOW_VIP
    public void showVIP() {
        if (minHeap.isEmpty()) {
            System.out.println("No VIP users yet.");
            return;
        }

        // Sort descending before display
        List<UserSpend> list = new ArrayList<>(minHeap);
        list.sort((a, b) -> b.total - a.total);

        System.out.println("Top VIP Spenders:");
        for (UserSpend u : list) {
            System.out.println(u.user + " -> " + u.total);
        }
    }
}
