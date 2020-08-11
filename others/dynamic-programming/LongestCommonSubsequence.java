/*
 * Problem : https://www.techiedelight.com/longest-common-subsequence/
 */

import java.util.Random; // For test cases
import java.util.HashMap; // For memoization
import java.util.Map; // For memoization

class LongestCommonSubsequence {

    // Top Down or Memoization
    private static int LCSTopDown(String x, String y, int m, int n,
                                    Map<String, Integer> lookup) {
        if (m == 0 || n == 0) {
            return 0;
        }

        String key = m + "|" + n;

        if (!lookup.containsKey(key)) {
            if (x.charAt(m - 1) == y.charAt(n - 1)) {
                lookup.put(key, LCSTopDown(x, y, m - 1, n - 1, lookup) + 1);
            } else {
                lookup.put(key, Math.max(LCSTopDown(x, y, m - 1, n, lookup),
                                LCSTopDown(x, y, m, n -1, lookup)));
            }
        }

        return lookup.get(key);
    }

    public static int LCSTopDown(String X, String Y) {
        if (X == null || Y == null) {
            throw new IllegalArgumentException();
        }

        if (X.length() == 0 || Y.length() == 0) {
            return 0;
        }

        Map<String, Integer> lookup = new HashMap<>();

        return LCSTopDown(X, Y, X.length(), Y.length(), lookup);
     }

    // Naive recursive LCS
    private static int NaiveLCS(String X, String Y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return 1 + NaiveLCS(X, Y, m - 1, n -1);
        }

        return Math.max(NaiveLCS(X, Y, m - 1, n), NaiveLCS(X, Y, m, n - 1));
    }

    // Naive recursive LCS
    public static int NaiveLCS(String X, String Y) {
        if (X == null || Y == null) {
            throw new IllegalArgumentException();
        }

        if (X.length() == 0 || Y.length() == 0) {
            return 0;
        }

        return NaiveLCS(X, Y, X.length(), Y.length());
    }

    // Generate random string of upper case letters for test cases
    private static String generateRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int lower = 65; // ascii of upper case A

        for (int i = 0; i < length; ++i) {
            int next = lower + random.nextInt(5);  // consider only A, B, C, D
            sb.append((char)next);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int max = 10;
        String X = LongestCommonSubsequence.generateRandomString(max);
        String Y = LongestCommonSubsequence.generateRandomString(max);

        int length = LongestCommonSubsequence.NaiveLCS(X, Y);
        System.out.println("Using naive recursion, LCS of " + X + " and " + Y + " : " + length);

        length = LongestCommonSubsequence.NaiveLCS(X, Y);
        System.out.println("Using naive recursion, LCS of " + X + " and " + Y + " : " + length);

        length = LongestCommonSubsequence.LCSTopDown(X, Y);
        System.out.println("Using naive recursion, LCS of " + X + " and " + Y + " : " + length);
    }
}

