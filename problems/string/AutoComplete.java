/*
 * Problem : https://www.geeksforgeeks.org/auto-complete-feature-using-trie/
 */

import java.util.List;
import java.util.LinkedList;

public class AutoComplete {
    private static final int R = 26;
    private Node root;

    private static class Node {
        boolean isEndOfWord;
        Node[] next;

        public Node() {
            next = new Node[R];
            for (int i = 0; i < R; ++i) {
                next[i] = null;
            }
            isEndOfWord = false;
        }
    }

    public AutoComplete() {
        root = new Node();
    }

    private int getIndex(char c) {
        return (int)c - 'a';
    }

    public void insert(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        Node temp = root;
        for (int i = 0; i < key.length(); ++i) {
            int index = getIndex(key.charAt(i));
            if (temp.next[index] == null) {
                temp.next[index] = new Node();
            }
            temp = temp.next[index];
        }
        temp.isEndOfWord = true;
    }

    private boolean isTerminalNode(Node node) {
        for (int i = 0; i < node.next.length; ++i) {
            if (node.next[i] != null) {
                return false;
            }
        }
        return true;
    }

    private void searchRec(Node node, String prefix, List<String> list) {
        if (node.isEndOfWord) {
            list.add(prefix);
        }

        if (isTerminalNode(node)) {
            return;
        }

        for (int i = 0; i < node.next.length; ++i) {
            if (node.next[i] != null) {
                char c = (char)('a' + i);
                searchRec(node.next[i], prefix + c, list);
            }
        }
    }

    private List search(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        Node temp = root;
        for (int i = 0; i < key.length(); ++i) {
            int index = getIndex(key.charAt(i));
            if (temp.next[index] == null) {
                return null;
            }
            temp = temp.next[index];
        }

        List<String> list = new LinkedList<String>();

        // If this prefix is in last node of tree
        if (temp.isEndOfWord && isTerminalNode(temp)) {
            list.add(key);
        } else if (!isTerminalNode(temp)) {
            // There are more nodes below this node
            String prefix = key;
            searchRec(temp, prefix, list);
        }

        return list;
    }

    public static void main(String[] args) {
        String[] words = {"geeks", "for", "geeks", "a", "portal",
            "to", "learn", "can", "be", "computer",
            "science", "zoom", "yup", "fire", "in", "data", "hell",
            "hello", "helping", "hel", "help", "helps", "helping"};

        AutoComplete auto = new AutoComplete();
        for (int i = 0; i < words.length; ++i) {
            auto.insert(words[i]);
        }

        String prefix = "a";
        List<String> list = auto.search(prefix);
        if (list == null || list.size() == 0) {
            System.out.println("No words found for " + prefix);
        } else {
            System.out.println("Words found for " + prefix + " " + list);
        }
    }
}
