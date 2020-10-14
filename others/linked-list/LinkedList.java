/*
 *  https://www.techiedelight.com/clone-given-linked-list/
 * https://www.techiedelight.com/split-nodes-given-linked-list-front-back-halves/
 */

import java.util.Random;

class LinkedList {
    private class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    private Node head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public void addFirst(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }

    public void addLast(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(data);
    }

    public int pop() {
        if (head == null) {
            System.out.println("Linked List underflow");
            return Integer.MIN_VALUE;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp.data;
    }

    public int deleteLast() {
        if (head == null) {
            System.out.println("Linked List underflow");
            return Integer.MIN_VALUE;
        }

        Node temp = head;
        Node prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }

        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }
        return temp.data;
    }

    public LinkedList clone() {
        if (isEmpty()) {
            return new LinkedList();
        }

        LinkedList cloned = new LinkedList();
        Node ptr = head;
        Node tail = null;
        while (ptr != null) {
            if (tail == null) {
                cloned.head = new Node(ptr.data);
                tail = cloned.head;
            } else {
                tail.next = new Node(ptr.data);
                tail = tail.next;
            }
            ptr = ptr.next;
        }
        return cloned;
    }

    private Node cloneRec(Node node) {
        if (node == null) {
            return null;
        }

        Node temp = new Node(node.data);
        temp.next = cloneRec(node.next);
        return temp;
    }

    public LinkedList cloneRec() {
        if (isEmpty()) {
            return new LinkedList();
        }

        LinkedList cloned = new LinkedList();
        cloned.head = cloneRec(head);
        return cloned;
    }

    public LinkedList[] splitList() {
        LinkedList front = new LinkedList();
        LinkedList back = new LinkedList();
        if (head == null || head.next == null) {
            front.head = head;
            back.head = null;
            return new LinkedList[] {front, back};
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        back.head = slow.next;
        front.head = head;
        slow.next = null;

        return new LinkedList[] {front, back};
    }
}

class Driver {
    private static Random random = new Random();

    private static void printArray(int[] array) {
        for (int a: array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    private static int getNumber(int max) {
        return random.nextInt(max);
    }

    private static int[] getRandomArray(int max, int numbers) {
        int[] array = new int[numbers];

        for (int i = 0; i < numbers; i++) {
            array[i] = random.nextInt(max) + 1;
        }
        return array;
    }

    public static void main(String[] args) {
        int max = 15;
        int num = 20;

        int[] array = Driver.getRandomArray(max, num);
        Driver.printArray(array);

        System.out.println("======================================================");
        LinkedList list = new LinkedList();
        for (int a : array) {
            list.addFirst(a);
        }
        list.printList();

        System.out.println("======================================================");
        LinkedList list2 = new LinkedList();
        for (int a : array) {
            list2.addLast(a);
        }
        list2.printList();

        System.out.println("list2 pop : " + list2.pop());
        System.out.println("list2 delete last node : " + list2.deleteLast());
        list2.printList();


        System.out.println("======================================================");
        System.out.println("Cloning list2");
        LinkedList cloned = list2.clone();
        cloned.printList();

        System.out.println("======================================================");
        System.out.println("Cloning list2 recursively");
        LinkedList clonedR = list2.clone();
        clonedR.printList();

        System.out.println("======================================================");
        System.out.println("Splitting list1 int 2 halves");
        LinkedList[] splits = list.splitList();
        splits[0].printList();
        splits[1].printList();
    }
}
