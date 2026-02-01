package Problem_28_Memory_Manager.src;
import java.util.HashSet;
import java.util.Set;

public class RootSet {


    public class RootSet {

        private Set<Integer> roots;

        public RootSet() {
            roots = new HashSet<>();
        }

        public void addRoot(int index) {
            roots.add(index);
        }

        public void removeRoot(int index) {
            roots.remove(index);
        }

        public Set<Integer> getRoots() {
            return roots;
        }

        public void printRoots() {
            System.out.println("Roots: " + roots);
        }
    }

    
}
