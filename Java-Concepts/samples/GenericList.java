/**
* This program demonstrate the concept of generics.
*
* @author  Rahul Pawar
* @version 1.0
* @since   2020-06-12
*/

// Singly linked list storing Element type
public class GenericList<Element> {
    // Node class whose objects for the list
    private class Node {
        Element data;
        Node next;

        public Node(Element element) {
            data = element;
            next = null;
        }
    }

    Node first;
    int size;

    public GenericList() {
        first = null;
        size = 0;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return first == null;
    }

    // Return the size of list
    public int size() {
        return size;
    }

    // Add element at front of list
    public void insert(Element element) {
        Node node = new Node(element);

        if (isEmpty()) {
            first = node;
        } else {
            node.next = first;
        }
        first = node;
        size++;
    }

    // Remove the front element
    public Element delete() {
        // Ideally deleting from empty data structure should throw exception
        if (isEmpty()) {
            return null;
        }

        Element element = first.data;
        first = first.next;
        return element;
    }

    public static void main(String[] args) {
        GenericList<String> list = new GenericList<>();

        list.insert("Alice");
        list.insert("Bob");
        list.insert("Charlie");

        System.out.println(list.delete());
        System.out.println(list.delete());
        System.out.println(list.delete());
    }
}
