package src;

public class VIPTest {
    public static void main(String[] args) {
        VIPTracker tracker = new VIPTracker();

        tracker.purchase("U1", 100);
        tracker.purchase("U2", 200);
        tracker.purchase("U3", 300);
        tracker.purchase("U4", 50);
        tracker.purchase("U1", 250);

        tracker.showVIP();
    }
}
