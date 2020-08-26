/*
 * https://www.techiedelight.com/longest-repeated-subsequence-problem/
 */

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

class RepeatedSubsequence {
    private static void checkInput(String X) {
        if (X == null) {
            throw new IllegalArgumentException();
        }
    }

    private static int topDown(String X, String Y, int m, int n, Map<String, Integer> lookup) {
        if (m == 0 || n == 0) {
            return 0;
        }

        String key = m + "|" + n;
        if (!lookup.containsKey(key)) {
            int length = 0;
            if (X.charAt(m - 1) == Y.charAt(n - 1) && m != n) {
                length = 1 + topDown(X, Y, m - 1, n - 1, lookup);
            } else {
                length = Math.max(topDown(X, Y, m - 1, n, lookup), topDown(X, Y, m, n - 1, lookup));
            }
            lookup.put(key, length);
        }

        return lookup.get(key);
    }

    public static int topDown(String X) {
        checkInput(X);
        return topDown(X, X, X.length(), X.length(), new HashMap<String, Integer>());
    }

    private static int recursion(String X, String Y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1) && m != n) {
            return 1 + recursion(X, Y, m - 1, n - 1);
        }

        return Math.max(recursion(X, Y, m , n - 1), recursion(X, Y, m - 1, n));
    }

    public static int recursion(String X) {
        checkInput(X);
        return recursion(X, X, X.length(), X.length());
    }
}

class Driver {
    private static String generateString(int length, char[] alphabets) {
        int n = alphabets.length;
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; ++i) {
            int index = random.nextInt(n);
            sb.append(alphabets[index]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int length = 10;
        char[] alphabets = {'A', 'T', 'G', 'C'};

        String X = generateString(length, alphabets);
        System.out.println("X : " + X);

        System.out.println("Using recursion : " + RepeatedSubsequence.recursion(X));
        System.out.println("Using top down : " + RepeatedSubsequence.topDown(X));
    }
}
