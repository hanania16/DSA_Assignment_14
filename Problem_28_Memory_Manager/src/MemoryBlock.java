public class MemoryBlock {
        boolean allocated;
        boolean visited;
        int[] references;
        int refCount;

        public MemoryBlock() {
            allocated = false;
            visited = false;
            references = new int[10];
            refCount = 0;
        }

        public void addReference(int index) {
            references[refCount++] = index;
        }

        public void clearReferences() {
            refCount = 0;
        }


    }





