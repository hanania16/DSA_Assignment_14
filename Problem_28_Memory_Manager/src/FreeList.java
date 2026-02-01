


public class FreeList {

    class FreeNode {
        int index;
        FreeNode next;

        FreeNode(int index) {
            this.index = index;
            this.next = null;
        }
    }

        private FreeNode head;

        public void add(int index) {
            FreeNode node = new FreeNode(index);
            node.next = head;
            head = node;
        }

        public int get() {
            if (head == null) return -1;
            int index = head.index;
            head = head.next;
            return index;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }



