package Problem_28_Memory_Manager.src;

import java.util.LinkedList;

public class FreeList {

    private LinkedList<Integer> freeIndices;

    public FreeList() {
        freeIndices = new LinkedList<>();
    }

    public void add(int index) {
        freeIndices.add(index);
    }

    public int getFirstFree() {
        if (!freeIndices.isEmpty()) {
            return freeIndices.removeFirst();
        }
        return -1;
    }

    public boolean isEmpty() {
        return freeIndices.isEmpty();
    }

    public void printFreeList() {
        System.out.println("FreeList: " + freeIndices);
    }
}

