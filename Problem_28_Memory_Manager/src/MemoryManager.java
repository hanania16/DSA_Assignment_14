import java.util.*;

public class MemoryManager {

    private MemoryBlock[] heap;
    private Map<String, Integer> blockMap = new HashMap<>();
    private Set<Integer> roots = new HashSet<>();
    private FreeList freeList = new FreeList();

    public MemoryManager(int size) {
        heap = new MemoryBlock[size];
        for (int i = 0; i < size; i++) {
            heap[i] = new MemoryBlock();
            freeList.add(i);
        }
    }

    // ALLOC
    public void alloc(String blockId) {
        Integer index = freeList.getFreeBlock();

        if (index == null) {
            System.out.println("No free block. Running GC...");
            gc();
            index = freeList.getFreeBlock();
            if (index == null) {
                System.out.println("Allocation failed.");
                return;
            }
        }

        heap[index].allocated = true;
        heap[index].id = blockId;
        blockMap.put(blockId, index);

        System.out.println("Block " + blockId + " allocated at index " + index);
    }

    // REF
    public void ref(String from, String to) {
        if (!blockMap.containsKey(from) || !blockMap.containsKey(to)) {
            System.out.println("Invalid REF command. Block not found.");
            return;
        }
        heap[blockMap.get(from)].references.add(blockMap.get(to));
    }

    // ROOT
    public void root(String blockId) {
        if (blockMap.containsKey(blockId))
            roots.add(blockMap.get(blockId));
    }

    public void unroot(String blockId) {
        if (blockMap.containsKey(blockId))
            roots.remove(blockMap.get(blockId));
    }

    // GC
   public void gc() {
    System.out.println("--- Mark Phase ---");
    Stack<Integer> stack = new Stack<>();
    Map<Integer, Integer> parentMap = new HashMap<>(); // Track who references this block

    // Push roots to stack
    for (int root : roots) {
        stack.push(root);
        parentMap.put(root, -1); // -1 indicates root
    }

    while (!stack.isEmpty()) {
        int idx = stack.pop();
        MemoryBlock block = heap[idx];

        if (!block.visited) {
            block.visited = true;

            if (parentMap.get(idx) == -1) {
                System.out.println("Visiting " + block.id + " (root).");
            } else {
                String parentId = heap[parentMap.get(idx)].id;
                System.out.println("Visiting " + block.id + " (referenced by " + parentId + ").");
            }

            for (int ref : block.references) {
                if (!heap[ref].visited) {
                    stack.push(ref);
                    parentMap.put(ref, idx); // track parent
                }
            }
        }
    }

    // Sweep phase
    System.out.println("--- Sweep Phase ---");
    int freed = 0;
    for (int i = 0; i < heap.length; i++) {
        MemoryBlock block = heap[i];
        if (block.allocated && !block.visited) {
            System.out.println(block.id + " is unreachable. FREED.");
            block.allocated = false;
            block.id = null;
            block.references.clear();
            freeList.add(i);
            freed++;
        }
        block.reset();
    }
    System.out.println("Freed " + freed + " block(s).");
}


    // STATUS
public void status() {
    // Print Heap
    System.out.print("Heap: [");
    for (int i = 0; i < heap.length; i++) {
        if (heap[i].allocated) {
            System.out.print(heap[i].id);
            if (roots.contains(i)) System.out.print("*"); // mark root
        } else {
            System.out.print("FREE");
        }
        if (i != heap.length - 1) System.out.print(", ");
    }
    System.out.println("]");

    // Print Roots
    System.out.print("Roots: [");
    boolean first = true;
    for (int idx : roots) {
        if (!first) System.out.print(", ");
        System.out.print(heap[idx].id);
        first = false;
    }
    System.out.println("]");

    // Print References
    for (int i = 0; i < heap.length; i++) {
        if (heap[i].allocated) {
            System.out.print(heap[i].id + " -> [");
            for (int j = 0; j < heap[i].references.size(); j++) {
                int refIdx = heap[i].references.get(j);
                System.out.print(heap[refIdx].id);
                if (j != heap[i].references.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}

}
