/*
 * Problem : https://www.geeksforgeeks.org/sorting-array-strings-words-using-trie/
 */

import java.util.List;
import java.util.LinkedList;

// Assumption is that all characters are lower case
public class SortStringUsingTrie {
    private static final int R = 26;
    private Node root;
    private static class Node {
        int index;
        Node[] next;

        public Node() {
            next = new Node[R];
            for (int i = 0; i < 26; ++i) {
                next[i] = null;
            }
            index = -1;
        }
    }

    public SortStringUsingTrie() {
        root = new Node();
    }

    private static int getIndex(char c) {
        return (int)c - 'a';
    }

    public void insert(String key, int keyIndex) {
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
        temp.index = keyIndex;
    }

    private void preorder(Node node, String[] array, List<String> sorted) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < R; ++i) {
            if (node.next[i] != null) {
                if (node.next[i].index != -1) {
                    sorted.add(array[node.next[i].index]);
                }
                preorder(node.next[i], array, sorted);
            }
        }
    }

    public List<String> sort(String[] array) {
        List<String> sorted = new LinkedList<>();
        preorder(root, array, sorted);
        return sorted;
    }

    public static void main(String[] args) {
        String[] array = {"geeks", "for", "geeks", "a", "portal",
                          "to", "learn", "can", "be", "computer",
                          "science", "zoom", "yup", "fire", "in", "data"};

        System.out.println("Before sorting: ");
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        SortStringUsingTrie trie = new SortStringUsingTrie();
        for (int i = 0; i < array.length; ++i) {
            trie.insert(array[i], i);
        }

        List<String> sorted = trie.sort(array);
        System.out.println("After sorting: ");
        System.out.println(sorted);
    }
}
