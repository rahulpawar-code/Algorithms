import java.util.Queue;
import java.util.ArrayDeque;

public class IntervalST {
    private static class Interval {
        final int start;
        final int end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        public boolean isOverlapping(Interval other) {
            return start <= other.end && other.start <= end;
        }

        public String toString() {
            return new String("(" + start + ", " + end + ")");
        }
    }

    private class Node {
        final Interval inter;
        int maxEnd;
        Node left;
        Node right;

        public Node(Interval i) {
            inter = i;
            maxEnd = i.end;
            left = null;
            right = null;
        }
    }

    Node root;

    public IntervalST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Node insert(Node node, Interval i) {
        if (node == null) {
            return new Node(i);
        }

        if (i.start < node.inter.start) {
            node.left = insert(node.left, i);
        } else {
            node.right = insert(node.right, i);
        }

        if (i.end > node.maxEnd) {
            node.maxEnd = i.end;
        }

        return node;
    }

    private void inorder(Node node, Queue<Node> queue) {
        if (node == null) {
            return;
        }

        inorder(node.left, queue);
        queue.add(node);
        inorder(node.right, queue);
    }

    public Queue<Node> inorder() {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        inorder(root, queue);
        return queue;
    }

    public void insert(Interval i) {
        root = insert(root, i);
    }

    public Node search(Interval s) {
        Node x = root;
        while (x != null) {
            if (x.inter.isOverlapping(s)) {
                return x;
            } else if (x.left == null || (x.left.maxEnd < s.start)) {
                x = x. right;
            } else {
                x = x.left;
            }
        }
        return null;
    }

    public void searchAll(Node node, Interval s, Queue<Node> queue) {
        if (node == null) {
            return;
        }
        if (s.start > node.maxEnd) {
            return;
        }

        searchAll(node.left, s, queue);

        if (node.inter.isOverlapping(s)) {
            queue.add(node);
        }

        if (s.end < node.inter.start) {
            return;
        }
        searchAll(node.right, s, queue);
    }

    public Queue<Node> searchAll(Interval s) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        searchAll(root, s, queue);
        return queue;
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(15,20), new Interval(10,30),
                                new Interval(17,19), new Interval(5, 20),
                                new Interval(12, 15), new Interval(30, 40)
                                };

        IntervalST tree = new IntervalST();

        for (Interval i : intervals) {
            tree.insert(i);
        }

        for (Node n : tree.inorder()) {
            System.out.print(n.inter + " ");
        }
        System.out.println();

        Interval s = new Interval(1, 2);
        System.out.println(s + " overlaps with interval in tree : " + tree.search(s));

        s = new Interval(16, 19);
        for (Node n : tree.searchAll(s)) {
            System.out.print(n.inter + " ");
        }
        System.out.println();
    }
}
