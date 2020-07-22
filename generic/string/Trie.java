/*
 * Trie data structure for string symbol table
 */

import java.util.NoSuchElementException;

public class Trie<Value> {
    private static final int R = 26;   // Extended ASCII char set

    private Node root;                  // root of trie
    private int n;                      // number of keys in trie

    // R-way Node object
    private static class Node {
        private Object value;
        Node[] next;

        public Node() {
            next = new Node[R];
            value = null;
        }
    }

    public Trie() {
        root = null;
        n = 0;
    }

    public Value search(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (root == null) {
            throw new NoSuchElementException();
        }
        Node temp = root;
        for (int i = 0; i < key.length(); ++i) {
            int index = key.charAt(i) - 'a';
            if (temp.next[index] == null) {
                return null;
            }
            temp = temp.next[index];
        }
        return (Value)temp.value;
    }

    public boolean contains(String key) {
        return search(key) != null;
    }

    public void insert(String key, Value value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }

        if (root == null) {
            root = new Node();
        }

        Node temp = root;
        int length = key.length();

        for (int i = 0; i < length; ++i) {
            int index = key.charAt(i) - 'a';
            if (temp.next[index] == null) {
                temp.next[index] = new Node();
            }
            temp = temp.next[index];
        }

        temp.value = value;
        n++;
    }

    private boolean empty(Node node) {
        for (int i = 0; i < R; ++i) {
            if (node.next[i] != null) {
                return false;
            }
        }
        return true;
    }

    private Node remove(Node node, String key, int depth) {
        if (node == null) {
            return null;
        }
        if (depth == key.length()) {
            if (node.value != null) {
                n--;
                node.value = null;
            }
        } else {
            int index = key.charAt(depth) - 'a';
            node.next[index] = remove(node.next[index], key, depth + 1);
        }
        if (node.value != null || !empty(node)) {
            return node;
        }
        return null;
    }

    public void remove(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (root == null) {
            throw new NoSuchElementException();
        }

        root = remove(root, key, 0);
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        String[] keys = {"the", "a", "there", "answer", "any",
                         "by", "bye", "their", "z"};

        Trie<Integer> trie = new Trie<>();
        for (int i = 0; i < keys.length; ++i) {
            trie.insert(keys[i], i);
        }
        System.out.println("== Trie size : " + trie.size());

        for (int i = 0; i < keys.length; ++i) {
            if (trie.contains(keys[i])) {
                System.out.println(keys[i] + ": " + trie.search(keys[i]));
            } else {
                System.out.println(keys[i] + ": " + null);
            }
        }

        String[] remove = {"z", "the", "their"};
        for (int i = 0; i < remove.length; ++i) {
            System.out.println("Deleting " + remove[i]);
            trie.remove(remove[i]);
        }
        System.out.println("== Trie size : " + trie.size());
        for (int i = 0; i < keys.length; ++i) {
            if (trie.contains(keys[i])) {
                System.out.println(keys[i] + ": " + trie.search(keys[i]));
            } else {
                System.out.println(keys[i] + ": " + null);
            }
        }
    }
}
