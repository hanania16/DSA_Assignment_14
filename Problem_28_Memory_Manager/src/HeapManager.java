package Problem_28_Memory_Manager.src;

public class HeapManager {


        private MemoryBlock[] heap;
        private int size;

        public HeapManager(int size) {
            this.size = size;
            this.heap = new MemoryBlock[size];
            for (int i = 0; i < size; i++) {
                heap[i] = new MemoryBlock(); // Initialize each block
            }
        }

        public int allocateBlock() {
            for (int i = 0; i < size; i++) {
                if (!heap[i].allocated) {
                    heap[i].allocated = true;
                    return i;
                }
            }
            return -1;
        }

        public void freeBlock(int index) {
            if (index >= 0 && index < size && heap[index].allocated) {
                heap[index].allocated = false;
                heap[index].visited = false;
                heap[index].references.clear(); // remove all references
            }
        }

        public MemoryBlock[] getHeap() {
            return heap;
        }

        public void printHeapStatus() {
            System.out.println("Heap Status:");
            for (int i = 0; i < size; i++) {
                MemoryBlock block = heap[i];
                String status = block.allocated ? "ALLOCATED" : "FREE";
                System.out.println("Index " + i + ": " + status + ", references: " + block.references);
            }
        }
    }



