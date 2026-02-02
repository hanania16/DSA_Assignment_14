

public class GarbageCollector {

    private HeapManager heapManager;
    private RootSet rootSet;

    public GarbageCollector(HeapManager heapManager, RootSet rootSet) {
        this.heapManager = heapManager;
        this.rootSet = rootSet;
    }

    public void gc() {
        mark();
        sweep();
    }

    private void mark() {
        InStack stack = new InStack(heapManager.getHeap().length);
        int[] roots = rootSet.getRoots();
        int rootCount = rootSet.getCount();

        for (int i = 0; i < rootCount; i++) {
            int rootIndex = roots[i];
            if (!heapManager.getHeap()[rootIndex].visited) {
                stack.push(rootIndex);
            }
        }

        while (!stack.isEmpty()) {
            int current = stack.pop();
            MemoryBlock block = heapManager.getHeap()[current];

            if (!block.visited) {
                block.visited = true;
                System.out.println("Visiting block " + current);

                for (int i = 0; i < block.refCount; i++) {
                    int ref = block.references[i];
                    if (!heapManager.getHeap()[ref].visited) {
                        stack.push(ref);
                    }
                }
            }
        }
    }

    private void sweep() {
        MemoryBlock[] heap = heapManager.getHeap();
        int freed = 0;

        for (int i = 0; i < heap.length; i++) {
            MemoryBlock block = heap[i];
            if (block.allocated && !block.visited) {
                heapManager.freeBlock(i);
                freed++;
                System.out.println("Block " + i + " freed");
            } else if (block.allocated) {
                block.visited = false; // reset for next GC
            }
        }

        System.out.println("Freed " + freed + " block(s).");
    }
}
