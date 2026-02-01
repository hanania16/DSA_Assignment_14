import java.util.*;

public class VIPSpenderTracker {

    private final int K = 3;

    private Map<String, Integer> totalSpendMap;
    private PriorityQueue<UserSpend> minHeap;

    public VIPSpenderTracker() {
        totalSpendMap = new HashMap<>();

        minHeap = new PriorityQueue<>(
            (a, b) -> a.totalSpend - b.totalSpend
        );
    }

    public void purchase(String userId, int amount) {
        int newTotal = totalSpendMap.getOrDefault(userId, 0) + amount;
        totalSpendMap.put(userId, newTotal);

        // Check if user already in heap
        UserSpend found = null;
        for (UserSpend us : minHeap) {
            if (us.userId.equals(userId)) {
                found = us;
                break;
            }
        }

        if (found != null) {
            minHeap.remove(found);
            minHeap.add(new UserSpend(userId, newTotal));
            return;
        }

        if (minHeap.size() < K) {
            minHeap.add(new UserSpend(userId, newTotal));
        } else if (newTotal > minHeap.peek().totalSpend) {
            minHeap.poll();
            minHeap.add(new UserSpend(userId, newTotal));
        }
    }

    public void showVIP() {
        List<UserSpend> list = new ArrayList<>(minHeap);
        list.sort((a, b) -> b.totalSpend - a.totalSpend);

        System.out.println("Top " + K + " VIP Spenders:");
        for (UserSpend us : list) {
            System.out.println(us.userId + " (" + us.totalSpend + ")");
        }
    }
}
