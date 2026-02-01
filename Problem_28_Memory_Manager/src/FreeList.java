import java.util.LinkedList;

public class FreeList {
    private LinkedList<Integer> freeBlocks = new LinkedList<>();

    public void add(int index) {
        freeBlocks.add(index);
    }

    public Integer getFreeBlock() {
        if (freeBlocks.isEmpty()) return null;
        return freeBlocks.removeFirst(); // First-Fit
    }

    public boolean isEmpty() {
        return freeBlocks.isEmpty();
    }
}
