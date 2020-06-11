class StackOfStrings {
    private Node head;
    private int size;

    private class Node {
        String item;
        Node next;

        public Node(String s) {
            item = s;
            next = null;
        }
    }

    public StackOfStrings() {
        head = null;
        size = 0;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public void push(String s) {
        Node temp = new Node(s);
        if (!isEmpty()) {
            temp.next = head;
        }
        head = temp;
        size++;
    }

    public String pop() {
       if (isEmpty()) {
            return null;
       }
       Node temp = head;
       head = head.next;
       temp.next = null;
       size--;
       return temp.item;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        String[] strings = {"a", "b", "c", "d"};

        StackOfStrings stack = new StackOfStrings();
        System.out.println("Size : " + stack.size());
        for (String s : strings) {
            stack.push(s);
            System.out.println("Size : " + stack.size());
        }

        while (!stack.isEmpty()) {
            System.out.println("Pop : " + stack.pop());
        }
        System.out.println("Size : " + stack.size());
    }
}
