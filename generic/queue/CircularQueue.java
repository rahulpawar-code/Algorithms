import java.util.NoSuchElementException;

class CircularQueue {
    private String[] queue;
    private int n;
    private int first;
    private int last;

    public CircularQueue() {
        queue = new String[2];
        n = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < n; ++i) {
            copy[i] = queue[(first + i) % queue.length];
        }
        queue = copy;
        first = 0;
        last = n;
    }

    public void enqueue(String s) {
        if (n == queue.length) {
            resize(2 * queue.length);
        }
        queue[last++] = s;
        if (last == queue.length) {
            last = 0;
        }
        n++;
    }

    public String dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException("Underflow");
        }

        String s = queue[first];
        queue[first] = null;
        first++;
        n--;
        if (first == queue.length) {
            first = 0;
        }
        if (n > 0 && n == queue.length / 4) {
            resize(queue.length / 2);
        }
        return s;
    }

    public static void main(String[] args) {
        String[] string = {"a", "b", "c", "d", "e"};
        CircularQueue queue = new CircularQueue();
        System.out.println("Size : " + queue.size() + ", isEmpty: " + queue.isEmpty());
        for (String s : string) {
            queue.enqueue(s);
            System.out.println("Size : " + queue.size() + ", isEmpty: " + queue.isEmpty());
        }

        while (!queue.isEmpty()) {
            System.out.println("Deuque : " + queue.dequeue());
            System.out.println("Size : " + queue.size() + ", isEmpty: " + queue.isEmpty());
        }
        System.out.println("Size : " + queue.size() + ", isEmpty: " + queue.isEmpty());
    }

}
