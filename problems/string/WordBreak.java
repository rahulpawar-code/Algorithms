/*
 * Problem : https://www.geeksforgeeks.org/word-break-problem-trie-solution/
 * https://www.techiedelight.com/word-break-problem-using-trie/
 */

import java.util.Map;
import java.util.HashMap;

// Class to represent trie node
class TrieNode {
    boolean isLeaf; // mark the leaf node also the end of the string key
    Map<Character, TrieNode> next; // mpa to store the children of node

    public TrieNode() {
        isLeaf = false;
        next = new HashMap<>();
    }
}

// Class to represent the trie
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Return root node
    public TrieNode getRoot() {
        return root;
    }

    // Iteratively insert new key in trie
    public void insert(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        TrieNode current = root;
        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            current.next.putIfAbsent(c, new TrieNode());
            current = current.next.get(c);
        }

        current.isLeaf = true;
    }

    // Iteratively search key in trie
    public boolean search(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        TrieNode current = root;
        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (current.next.get(c) == null) {
                return false;
            }
            current = current.next.get(c);
        }
        return current.isLeaf; // search is successful only if this is a leaf node
    }
}

// Class to operate on word break using trie data structure
public class WordBreak {
    // Recursively find out if breaking word is possible or not
    private static boolean wordBreakRec(Trie trie, String word) {
        // If word is exhausted or a of 0 length
        if (word.length() == 0) {
            return true;
        }

        // Recursively break the word into 2 parts
        // 1. Prefix of word till ith length. Check if this prefix is present in trie
        // 2. Remaining subsring from ith till end. Recursovely solve this problem
        for (int i = 1; i <= word.length(); ++i) {
            if (trie.search(word.substring(0, i)) &&
                        WordBreak.wordBreakRec(trie, word.substring(i))) {
                return true;
            }
        }

        // Tried all prefixes but nothing break not possible
        return false;
    }

    // Helper function to call actual function
    public static boolean wordBreak(Trie trie, String word) {
        if (trie == null || word == null) {
            throw new IllegalArgumentException();
        }

        return wordBreakRec(trie, word);
    }

    // Test code
    public static void main(String[] args) {
        String dictionary[] = {"mobile","samsung","sam",
            "sung","man","mango",
            "icecream","and","go","i",
            "like","ice","cream"};

        Trie trie = new Trie();
        for (String w : dictionary) {
            trie.insert(w);
        }

        String word = "ilikemango";
        boolean possible = WordBreak.wordBreak(trie, word);
        System.out.println(possible);
    }
}
