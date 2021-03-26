import java.util.NoSuchElementException;


class LinkedQueue {
    private class Node {
        String item;
        Node next;

        public Node(String s) {
            item = s;
            next = null;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String s) {
        Node temp = new Node(s);
        if (isEmpty()) {
            first = temp;
        }
        if (last != null) {
            last.next = temp;
        }
        last = temp;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }

        Node temp = first;
        if (first == last) {
            last = null;
        }

        first = first.next;
        temp.next = null;
        size--;
        return temp.item;
    }

    public static void main(String[] args) {
       String[] string = {"a", "b", "c", "d"};
       LinkedQueue queue = new LinkedQueue();
       System.out.println("isempty : " + queue.isEmpty() + ", size : " + queue.size());
       for (String s : string) {
            System.out.print("enqueue: " + s + " ");
            queue.enqueue(s);
            System.out.println("isempty : " + queue.isEmpty() + ", size : " + queue.size());
       }

       while(!queue.isEmpty()) {
            System.out.print("Dequeue: " + queue.dequeue() + " ");
            System.out.println("isempty : " + queue.isEmpty() + ", size : " + queue.size());
       }
       System.out.println("isempty : " + queue.isEmpty() + ", size : " + queue.size());
    }
}
