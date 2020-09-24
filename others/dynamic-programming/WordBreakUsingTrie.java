/*
 * https://www.techiedelight.com/word-break-problem-using-trie/
 * https://www.techiedelight.com/word-break-problem/ for memoization solution
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class TrieNode {
    private static final int CHAR_SIZE = 26;
    Map<Character, TrieNode> next;
    boolean isLeaf;

    public TrieNode() {
        isLeaf = false;
        next = new HashMap<>();
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

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
        return current.isLeaf;
    }

    public TrieNode getRoot() {
        return root;
    }
}

class Driver {
    private static boolean wordBreakRec(Trie trie, String word) {
        if (word.length() == 0) {
            return true;
        }

        for (int i = 1; i <= word.length(); ++i) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (trie.search(prefix) && wordBreakRec(trie, suffix)) {
                return true;
            }
        }

        return false;
    }

    public static boolean wordBreak(Trie trie, String word) {
        if (trie == null || word == null) {
            throw new IllegalArgumentException();
        }

        return wordBreakRec(trie, word);
    }

    private static boolean wordBreakRecMem(Trie trie, String word, int[] lookup) {
        int n = word.length();

        if (n == 0) {
            return true;
        }

        if (lookup[n] == -1) {
            lookup[n] = 0;
            for (int i = 0; i <= n; ++i) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                if (trie.search(prefix) && wordBreakRecMem(trie, suffix, lookup)) {
                    lookup[n] = 1;
                    return true;
                }
            }
        }

        return lookup[n] == 1;
    }

    public static boolean wordBreakMem(Trie trie, String word) {
        if (trie == null || word == null) {
            throw new IllegalArgumentException();
        }

        int[] lookup = new int[word.length() + 1];
        Arrays.fill(lookup, 1);
        return wordBreakRecMem(trie, word, lookup);
    }


    private static boolean wordBreakIter(Trie trie, String word) {
        boolean[] good = new boolean[word.length() + 1];
        good[0] = true;
        int n = word.length();

        for (int i = 0; i < n; ++i) {
            if (good[i]) {
                TrieNode current = trie.getRoot();
                for (int j = i; j < n; ++j) {
                    if (current == null) {
                        break;
                    }

                    current = current.next.get(word.charAt(j));
                    if (current != null && current.isLeaf) {
                        good[j + 1] = true;
                    }
                }
            }
        }

        return good[n];
    }

    public static boolean wordBreak2(Trie trie, String word) {
        if (trie == null || word == null) {
            throw new IllegalArgumentException();
        }

        return wordBreakIter(trie, word);
    }

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
        System.out.println("Possible to break word : " + Driver.wordBreak(trie, word));
        System.out.println("Possible to break word : " + Driver.wordBreak2(trie, word));
        System.out.println("Possible to break word : " + Driver.wordBreakMem(trie, word));
    }
}
