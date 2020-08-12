/*
 * Problem : https://www.techiedelight.com/longest-common-subsequence/
 */

import java.util.Random; // For test cases
import java.util.HashMap; // For memoization
import java.util.Map; // For memoization

class LongestCommonSubsequence {
    private static void validateInputs(String X, String Y) {
        if (X == null || Y == null) {
            throw new IllegalArgumentException();
        }
    }

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
        validateInputs(X, Y);

        Map<String, Integer> lookup = new HashMap<>();

        return LCSTopDown(X, Y, X.length(), Y.length(), lookup);
     }

    // Bottom up iterative solution with lookup table
    public static int BottomUpLCS(String X, String Y) {
        validateInputs(X, Y);
        int m = X.length();
        int n = Y.length();

        int[][] length = new int[m + 1][n + 1];

        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 || j == 0) {
                    length[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    length[i][j] = length[i - 1][j - 1] + 1;
                } else {
                    length[i][j] = Math.max(length[i - 1][j], length[i][j - 1]);
                }
            }
        }
        return length[m][n];
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
        validateInputs(X, Y);
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
        int max = 15;
        int length = 0;
        String X = LongestCommonSubsequence.generateRandomString(max);
        String Y = LongestCommonSubsequence.generateRandomString(max);

        length = LongestCommonSubsequence.NaiveLCS(X, Y);
        System.out.println("Using naive recursion, LCS of " + X + " and " + Y + " : " + length);

        length = LongestCommonSubsequence.LCSTopDown(X, Y);
        System.out.println("Using top down memoization, LCS of " + X + " and " + Y + " : " + length);

        length = LongestCommonSubsequence.BottomUpLCS(X, Y);
        System.out.println("Using bottom up tabulation, LCS of " + X + " and " + Y + " : " + length);
    }
}

