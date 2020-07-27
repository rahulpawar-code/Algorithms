/*
 * Problem : https://www.geeksforgeeks.org/implement-a-dictionary-using-trie/?ref=rp
 */

import java.util.HashMap;

public class WordMeaningDictionary {
    private Node root;

    // Node represent basic node of trie
    // Use hashmap to store next pointers
    private class Node {
        String meaning;
        HashMap<Character, Node> next;

        public Node() {
            meaning = null;
            next = new HashMap<>();
        }
    }

    public WordMeaningDictionary() {
        root = new Node();
    }

    // If there no child of this node
    public boolean isTerminalNode(Node node) {
        return node.next.isEmpty();
    }

    // Insert the key and meaning of this key
    public void insert(String key, String meaning) {
        if (key == null || meaning == null) {
            throw new IllegalArgumentException();
        }

        Node temp = root;
        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (temp.next.get(c) == null) {
                temp.next.put(c, new Node());
            }
            temp = (Node)temp.next.get(c);
        }
        temp.meaning = meaning;
    }

    // Search for key and fetch the meaning otherwise return null
    public String meaning(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node temp = root;
        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (temp.next.get(c) == null) {
                return null;
            }
            temp = (Node)temp.next.get(c);
        }
        return temp.meaning;
    }

    public static void main(String[] args) {
        String[] words = {"language", "the method of human communication",
                          "computer", "A computer is a machine that can be instructed to carry out sequences of arithmetic or",
                         "map", "a diagrammatic representation of an area",
                         "book", "a written or printed work consisting of pages glued",
                         "science", "study of nature"};

        WordMeaningDictionary dict = new WordMeaningDictionary();
        for (int i = 0; i < words.length; i = i + 2) {
            dict.insert(words[i], words[i + 1]);
        }

        String word = "book";
        String meaning = dict.meaning(word);
        if (meaning != null) {
            System.out.println(meaning);
        } else {
            System.out.println("No meaning for " + word);
        }
    }
}
