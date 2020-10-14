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

    public LinkedList(Node node) {
        head = node;
    }

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

    public void AlternatingSplitRec(Node odd, Node even) {
        if (odd == null || even == null) {
            return;
        }

        if (odd.next != null) {
            odd.next = odd.next.next;
        }

        if (even.next != null) {
            even.next = even.next.next;
        }

        AlternatingSplitRec(odd.next, even.next);
    }

    public LinkedList[] AlternatingSplitRec() {
        if (head == null || head.next == null) {
            return new LinkedList[] {new LinkedList(head), new LinkedList(null)};
        }

        Node odd = head;
        Node even = head.next;
        AlternatingSplitRec(odd, even);
        return new LinkedList[] {new LinkedList(odd), new LinkedList(even)};
    }

    public LinkedList[] AlternatingSplitIter() {
        Node current = head;
        Node nodeA = null;
        Node nodeB = null;

        while (current != null) {
            Node temp = current;
            current = current.next;

            temp.next = nodeA;
            nodeA = temp;

            if (current != null) {
                temp = current;
                current = current.next;

                temp.next = nodeB;
                nodeB = temp;
            }
        }

        return new LinkedList[] {new LinkedList(nodeA),
                                new LinkedList(nodeB)};
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
        LinkedList list = new LinkedList();
        for (int a : array) {
            list.addFirst(a);
        }
        list.printList();

        System.out.println("\nRecursive alternating split list in 2 halves");
        LinkedList[] splits = list.AlternatingSplitRec();
        splits[0].printList();
        splits[1].printList();
        System.out.println("======================================================");

        int[] array2 = Driver.getRandomArray(max, num);
        LinkedList list2 = new LinkedList();
        for (int a : array2) {
            list2.addFirst(a);
        }
        list2.printList();

        System.out.println("\nIterative alternating split list in 2 halves");
        LinkedList[] splits2 = list2.AlternatingSplitIter();
        splits2[0].printList();
        splits2[1].printList();
        System.out.println("======================================================");
    }
}
