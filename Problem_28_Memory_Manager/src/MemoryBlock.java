import java.util.ArrayList;
import java.util.List;

public class MemoryBlock {
    String id;
    boolean allocated;
    boolean visited;
    List<Integer> references;

    public MemoryBlock() {
        this.allocated = false;
        this.visited = false;
        this.references = new ArrayList<>();
    }

    public void reset() {
        visited = false;
    }
}
