import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private class Node {
        Item data;
        Node next;

        public Node(Item d) {
            data = d;
            next = null;
        }
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Node current;

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

            Item temp = current.data;
            current = current.next;
            return temp;
        }
    }

    private Node first;
    private int size;

    public RandomizedQueue() {
        size = 0;
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node temp = new Node(item);
        size++;
        if (!isEmpty()) {
            temp.next = first;
        }
        first = temp;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int number = StdRandom.uniform(1, size + 1);

        number--;
        if (number == 0) {
            Item item = first.data;
            first = first.next;
            size--;
            return item;
        }

        Node temp = first;
        Node back = null;
        while (number > 0) {
            back = temp;
            temp = temp.next;
            number--;
        }

        back.next = temp.next;
        size--;
        return temp.data;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int number = StdRandom.uniform(1, size + 1);

        number--;
        Node temp = first;
        while (number > 0) {
            temp = temp.next;
            number--;
        }
        return temp.data;
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    public static void main(String[] args) {
        String[] string = {"a", "b", "c", "d", "e"};

        RandomizedQueue<String> queue = new RandomizedQueue<>();

        StdOut.println("Size " + queue.size() + ", isempty: " + queue.isEmpty());
        for (String s : string) {
            queue.enqueue(s);
            StdOut.println("Size " + queue.size() + ", isempty: " + queue.isEmpty());
        }
        StdOut.println("======");
        for (int i = 0; i < queue.size(); ++i)  {
            StdOut.println(queue.sample());
        }
        StdOut.println("======");

        while (!queue.isEmpty()) {
            StdOut.println(queue.dequeue());
            StdOut.println("Size " + queue.size() + ", isempty: " + queue.isEmpty());
        }
    }
}

