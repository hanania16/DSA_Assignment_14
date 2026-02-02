

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int heapSize = 5;
        HeapManager heap = new HeapManager(heapSize);
        RootSet roots = new RootSet(heapSize);
        GarbageCollector gc = new GarbageCollector(heap, roots);

        System.out.println("Memory Block Manager Started");
        System.out.println("Commands: ALLOC, REF, ROOT, UNROOT, GC, STATUS, EXIT");

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine().trim();
            String[] parts = input.split(" ");

            if (parts.length == 0) continue;

            String command = parts[0].toUpperCase();

            switch (command) {

                case "ALLOC":
                    int index = heap.allocateBlock();
                    if (index == -1) {
                        System.out.println("Heap full! Run GC to free blocks.");
                    } else {
                        System.out.println("Block allocated at index " + index);
                    }
                    break;

                case "REF":
                    if (parts.length < 3) {
                        System.out.println("Usage: REF <fromIndex> <toIndex>");
                        break;
                    }
                    int from = Integer.parseInt(parts[1]);
                    int to = Integer.parseInt(parts[2]);
                    heap.addReference(from, to);
                    break;

                case "ROOT":
                    if (parts.length < 2) {
                        System.out.println("Usage: ROOT <blockIndex>");
                        break;
                    }
                    int rootIndex = Integer.parseInt(parts[1]);
                    roots.addRoot(rootIndex);
                    System.out.println("Block " + rootIndex + " added to roots");
                    break;

                case "UNROOT":
                    if (parts.length < 2) {
                        System.out.println("Usage: UNROOT <blockIndex>");
                        break;
                    }
                    int unrootIndex = Integer.parseInt(parts[1]);
                    roots.removeRoot(unrootIndex);
                    System.out.println("Block " + unrootIndex + " removed from roots");
                    break;

                case "GC":
                    System.out.println("Running Garbage Collection...");
                    gc.gc();
                    break;

                case "STATUS":
                    heap.printHeapStatus();
                    roots.printRoots();
                    break;

                case "EXIT":
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Unknown command");
            }
        }
    }
}

