/*
 * Problem : https://www.techiedelight.com/longest-common-prefix-given-set-strings-using-trie/
 *  https://www.geeksforgeeks.org/longest-common-prefix-using-trie/?ref=rp
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

// A class representing trie node
class Node {
    boolean isLeafNode = false;  // set if this is a leaf node means a word end here
    Map<Character, Node> next = new HashMap<>(); // next pointer for storig children
}

public class LongestCommonPrefix {
    // Insert string in trie
    public static void insert(Node root, String str) {
        if (root == null || str == null) {
            throw new IllegalArgumentException();
        }

        Node crawl = root;  // pointer to crawl tree

        for (char c : str.toCharArray()) {
            crawl.next.putIfAbsent(c, new Node());  // add new node if path doesn't exists
            crawl = crawl.next.get(c);  // move to next node
        }

        crawl.isLeafNode = true;  // word is inserted, mark this as a leaf node
    }

    // Find the longest common prefix
    public static String findLCP(List<String> words) {
        if (words == null) {
            throw new IllegalArgumentException();
        }

        // Create a trie
        Node trieHead = new Node();

        // Insert into trie one by one
        for (String word : words) {
            insert(trieHead, word);
        }

        StringBuilder sb = new StringBuilder();

        // Traverse the trie for lcp
        Node current = trieHead;

        // Traverse till a leaf node or node has more than 1 child
        while (current != null && !current.isLeafNode && (current.next.size() == 1)) {
            // get the child node
            for (var entry : current.next.entrySet()) {
                sb.append(entry.getKey());  // append current character to common prefix
                current = entry.getValue(); // move to child node
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codependence", "codependency", "codependent",
                "codependents", "codes", "codesign", "codesigned", "codeveloped",
                "codeveloper", "codex", "codify", "codiscovered", "codrive"
                );
        System.out.println("Longest Common prefix is : " + findLCP(words));

        List<String> words2 = Arrays.asList("geeksforgeeks", "geeks",
                "geek", "geezer");
        System.out.println("Longest Common prefix is : " + findLCP(words2));
    }
}
