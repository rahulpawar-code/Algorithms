import java.util.NoSuchElementException;

class DynamicStack {
    private String[] stack;
    private int top;

    public DynamicStack() {
        top = 0;
        stack = new String[2];
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < top; ++i) {
            copy[i] = stack[i];
        }
        stack = copy;
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(String s) {
        if (top == stack.length) {
            resize(stack.length * 2);
        }
        stack[top++] = s;
    }

    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }

        String item = stack[top - 1];
        stack[top - 1] = null;
        top--;

        if (top > 0 && top == stack.length / 4) {
            resize(stack.length / 2);
        }

        return item;
    }

    public static void main(String[] args) {
        String[] string = {"a", "b", "c", "d", "e"};
        DynamicStack stack = new DynamicStack();
        System.out.println("IsEmpty : " + stack.isEmpty() + ", size: " + stack.size());
        for (String s : string) {
            System.out.print("Push : " + s + " , ");
            stack.push(s);
            System.out.println("IsEmpty : " + stack.isEmpty() + ", size: " + stack.size());
        }

        while(!stack.isEmpty()) {
            System.out.print("Pop : " + stack.pop() + " ");
            System.out.println("IsEmpty : " + stack.isEmpty() + ", size: " + stack.size());
        }
        System.out.println("IsEmpty : " + stack.isEmpty() + ", size: " + stack.size());
    }
}
