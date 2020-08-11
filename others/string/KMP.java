/*
 * Problem : https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 * https://www.techiedelight.com/implementation-kmp-algorithm-c-cpp-java/
 * 
 * For computation and explaination watch this video
 * https://www.youtube.com/watch?v=BXCEFAzhxGY&feature=em-comments
 */

import java.util.List;
import java.util.LinkedList;

class Search {
    // To work through this method watch video and try to create array on
    // example DADAXDADADZ
    private static int[] computeLPS(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        int max = 0;
        int n = s.length();
        int[] lps = new int[n];
        int index = 1;
        
        while (index < n) {
            if (s.charAt(max) == s.charAt(index)) {
                lps[index] = ++max;
                index++;
            } else if (max != 0) {
                max = lps[max - 1];
            } else {
                lps[index] = 0;
                index++;
            }
        }
        return lps;       
    }
    
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    public static List<Integer> searchPattern(String text, String pattern) {
        if (text == null || pattern == null) {
            throw new IllegalArgumentException();
        }
        
        int[] lps = computeLPS(pattern);
        List<Integer> list = new LinkedList<>();

        for (int i = 0, j = 0; i < text.length(); ++i) {
            if (j < pattern.length() && text.charAt(i) == pattern.charAt(j)) {
                if (++j == pattern.length()) {
                    list.add(i - j + 1);
                }
            } else if (j > 0) {
                j = lps[j - 1];
                i--;
            }
        }
        
        return list;
    }
}

public class KMP {
    public static void main(String[] args) {
        String[] text = {"DADAXDADADZ", "ABCABAABCABAC", "ABABDABACDABABCABAB"};
        String[] pattern = {"DA", "CAB", "ABABCABAB"};
        
        for (int i = 0; i < text.length; ++i) {
            List<Integer> list = Search.searchPattern(text[i], pattern[i]);
            System.out.println(pattern[i] + " appeared in " + text[i] + " with at an index " + list);
        }
    }
}
