package Problem_28_Memory_Manager.src;
import java.util.ArrayList;
import java.util.List;

public class MemoryBlock {


        boolean allocated;

        boolean visited;

        List<Integer> references;

        public MemoryBlock() {
            this.allocated = false;
            this.visited = false;
            this.references = new ArrayList<>();
        }

        public void resetVisited() {
            this.visited = false;
        }
    }



