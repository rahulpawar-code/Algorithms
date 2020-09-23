/*
 * https://www.techiedelight.com/word-break-problem/
 */

import java.util.HashSet;

class WordBreak {
    public static boolean wordBreak(HashSet<String> dictionary, String word) {
        if (word.length() == 0) {
            return true;
        }

        for (int i = 1; i <= word.length(); ++i) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (dictionary.contains(left) && wordBreak(dictionary, right)) {
                return true;
            }
        }
        return false;
    }

    public static void printWordBreak(HashSet<String> dictionary, String word, String out) {
        if (word.length() == 0) {
            System.out.println(out);
            return;
        }

        for (int i = 1; i <= word.length(); ++i) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (dictionary.contains(prefix)) {
                printWordBreak(dictionary, suffix, out + " " + prefix);
            }
        }
    }
}

class Driver {
    public static void main(String[] args) {
        String[] words = {"this", "th", "is", "famous",
            "Word", "break", "b", "r", "e", "a", "k",
            "br", "bre", "brea", "ak", "problem"};

        HashSet<String> dictionary = new HashSet<>();
        for (String s: words) {
            dictionary.add(s);
        }

        String word = "Wordbreakproblem";
        System.out.println("Is word break possible : " + WordBreak.wordBreak(dictionary, word));

        System.out.println("\nWord breaks:");
        WordBreak.printWordBreak(dictionary, word, "");
    }
}
