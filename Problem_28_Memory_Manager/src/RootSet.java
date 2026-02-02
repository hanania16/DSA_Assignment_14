

public class RootSet {

    private int[] roots;
    private int count;

    public RootSet(int size) {
        roots = new int[size];
        count = 0;
    }

    public void addRoot(int index) {
        for (int i = 0; i < count; i++) if (roots[i] == index) return;
        roots[count++] = index;
    }

    public void removeRoot(int index) {
        for (int i = 0; i < count; i++) {
            if (roots[i] == index) {
                roots[i] = roots[count - 1];
                count--;
                return;
            }
        }
    }

    public int[] getRoots() {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) result[i] = roots[i];
        return result;
    }
    public int getCount() {
        return count;
    }

    public void printRoots() {
        System.out.print("Roots: [");
        for (int i = 0; i < count; i++) {
            System.out.print(roots[i]);
            if (i < count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }


}

