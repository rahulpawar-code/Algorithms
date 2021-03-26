import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        Item data;
        Node next;

        public Node(Item d) {
            data = d;
            next = null;
        }
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            Item item = current.data;
            current = current.next;
            return item;
        }

    }

    private Node first;
    private Node last;
    private int size;

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node temp = new Node(item);
        if (isEmpty()) {
            last = temp;
        } else {
            temp.next = first;
        }
        first = temp;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node temp = new Node(item);
        if (isEmpty()) {
            first = temp;
        } else {
            last.next = temp;
        }
        last = temp;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item temp = first.data;

        if (first == last) {
            last = null;
        }
        first = first.next;
        size--;
        return temp;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = last.data;
        size--;

        if (first == last) {
            first = null;
            last = null;
            return item;
        }

        Node temp = first;
        while (temp.next != last) {
            temp = temp.next;
        }
        temp.next = null;
        last = temp;
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    public static void main(String[] args) {
        String[] items = {"a", "b", "c", "d", "e"};
        Deque<String> queue = new Deque<>();
        StdOut.println("isEmpty : " + queue.isEmpty() + ", size " + queue.size());
        for (String i : items) {
            queue.addLast(i);
            StdOut.println("isEmpty : " + queue.isEmpty() + ", size " + queue.size());
        }

        StdOut.println("Iterating");
        for (String i : queue) {
            StdOut.print(i + " ");
        }
        StdOut.println("");

        while (!queue.isEmpty()) {
            StdOut.println("Removing " + queue.removeLast());
            StdOut.println("isEmpty : " + queue.isEmpty() + ", size " + queue.size());
        }
    }
}
