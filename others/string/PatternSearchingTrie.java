/*
 * Problem : https://www.geeksforgeeks.org/pattern-searching-using-trie-suffixes/
 */

import java.util.List;
import java.util.LinkedList;

class TrieNode {
    public static final int SIZE = 256;
    List<Integer> indices;
    TrieNode[] next;

    public TrieNode() {
        indices = new LinkedList<>();
        next = new TrieNode[SIZE];
    }
}

class SuffixTrie {
    TrieNode root;

    public SuffixTrie() {
        root = new TrieNode();
    }

    private void insertSuffix(String word, int startIndex) {
        if (word == null) {
            throw new IllegalArgumentException();
        }

        TrieNode temp = root;
        for (int i = 0; i < word.length(); ++i) {
            temp.indices.add(startIndex + i);
            if (temp.next[word.charAt(i)] == null) {
                temp.next[word.charAt(i)] = new TrieNode();
            }
            temp = temp.next[word.charAt(i)];
        }
    }

    public void insert(String word) {
        if (word == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < word.length(); ++i) {
           insertSuffix(word.substring(i), i);
        }
    }

    public List<Integer> search(String word) {
        if (word == null) {
            throw new IllegalArgumentException();
        }

        TrieNode temp = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (temp.next[c] == null) {
                return null;
            }
            temp = temp.next[c];
        }

        return temp.indices;
    }
}

public class PatternSearchingTrie {
    public static void main(String[] args) {
        String word = "thisisarandomstring";
        SuffixTrie trie = new SuffixTrie();
        trie.insert(word);

        String pattern = "s";
        List<Integer> indices = trie.search(pattern);
        if (indices != null) {
            for (int i : indices) {
                System.out.println(i - pattern.length());
            }
        } else {
            System.out.println(pattern + " not found in " + word);
        }
    }
}
