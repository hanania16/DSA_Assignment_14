

public class InStack {

    private int[] stack;
    private int top;

    public InStack(int size) {
        stack = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top < stack.length - 1) {
            stack[++top] = value;
        }
    }

    public int pop() {
        if (top >= 0) {
            return stack[top--];
        }
        return -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
