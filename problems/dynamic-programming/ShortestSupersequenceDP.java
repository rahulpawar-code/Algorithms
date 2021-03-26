/*
 * Problem : https://www.techiedelight.com/shortest-common-supersequence-introduction-scs-length/
 */

import java.util.HashMap;
import java.util.Map;

class ShortestSupersequenceDP {
    private static void checkInputs(String X, String Y) {
        if (X == null || Y == null) {
            throw new IllegalArgumentException();
        }
    }

    private static int recursion(String X, String Y, int m, int n) {
        if (m == 0 || n == 0) {
            return m + n;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return 1 + recursion(X, Y, m - 1, n -1);
        }

        return Math.min(recursion(X, Y, m - 1, n) + 1, recursion(X, Y, m, n -1) + 1);
    }

    public static int recursion(String X, String Y) {
        checkInputs(X, Y);
        return recursion(X, Y, X.length(), Y.length());
    }

    private static int topDown(String X, String Y, int m, int n,
                                Map<String, Integer> lookup) {
        if (m == 0 || n == 0) {
            return m + n;
        }

        String key = m + "|" + n;
        if (!lookup.containsKey(key)) {
            int length = 0;
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                length = topDown(X, Y, m - 1, n - 1, lookup) + 1;
            } else {
                length = Math.min(1 + topDown(X, Y, m - 1, n, lookup),
                                    1 + topDown(X, Y, m, n - 1, lookup));
            }
            lookup.put(key, length);
        }

        return lookup.get(key);
    }

    public static int topDown(String X, String Y) {
        checkInputs(X, Y);
        Map<String, Integer> lookup = new HashMap<>();
        return topDown(X, Y, X.length(), Y.length(), lookup);
    }

    private static int[][] getSCSTable(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] table = new int[m + 1][n + 1];

        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                int value = 0;
                if (i == 0) {
                    value = j;
                } else if (j == 0) {
                    value = i;
                } else if (X.charAt(i -1) == Y.charAt(j - 1)) {
                    value = 1 + table[i - 1][j - 1];
                } else {
                    value = Math.min(1 + table[i - 1][j], 1 + table[i][j - 1]);
                }
                table[i][j] = value;
            }
        }
        return table;
    }

    public static int bottomUp(String X, String Y) {
        checkInputs(X, Y);
        int[][] table = getSCSTable(X, Y);
        return table[X.length()][Y.length()];
    }
}

class Driver {
    public static void main(String[] args) {
        int lengthX = 10;
        int lengthY= 5;
        String X = RandomString.nextString(lengthX, RandomString.GENOME);
        String Y = RandomString.nextString(lengthY, RandomString.GENOME);

        System.out.println("X : " + X);
        System.out.println("Y : " + Y);
        System.out.println("Shortest supersequence length:");
        System.out.println("Using recursion : " + ShortestSupersequenceDP.recursion(X, Y));
        System.out.println("Using top down : " + ShortestSupersequenceDP.topDown(X, Y));
        System.out.println("Using bottom up : " + ShortestSupersequenceDP.bottomUp(X, Y));
    }
}
