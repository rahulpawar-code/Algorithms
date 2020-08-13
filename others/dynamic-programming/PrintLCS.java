/*
 * Problem : https://www.techiedelight.com/longest-common-subsequence-finding-lcs/
 */

import java.util.Random; // to generate random strings

class LCS {
    // Generate LCS string using the LCS table
    private static String LCSString(String X, String Y, int m, int n,
                                        int lcsLength, int[][] table) {
        char[] lcs = new char[lcsLength];

        while (m > 0 && n > 0) {
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                lcs[lcsLength - 1] = X.charAt(m - 1);
                m--;
                n--;
                lcsLength--;
            } else if (table[m - 1][n] > table[m][n - 1]) {
                m--;
            } else {
                n--;
            }
        }

        return new String(lcs);
    }

    // Generate the LCS table in bottom up fashion
    private static int[][] LCSTable(String X, String Y, int m, int n) {
        int[][] table = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return table;
    }

    public static String lcs(String X, String Y) {
        if (X == null || Y == null) {
            throw new IllegalArgumentException();
        }

        int m = X.length();
        int n = Y.length();
        int[][] table = LCSTable(X, Y, m, n, table);

        return LCSString(X, Y, m, n, table[m][n], table);
    }
}

public class PrintLCS {
    // Generate random string of length with chars upto maxChars from lower ascii value
    private static String generateRandomString(int length, int maxChars, int lower) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; ++i) {
            int next = lower + random.nextInt(maxChars);
            sb.append((char)next);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int max = 10;       // max length of string
        int maxChars = 6;  // only 6 chars
        int lower = 65; // ascii value of upper case A

        String X = PrintLCS.generateRandomString(max, maxChars, lower);
        String Y = PrintLCS.generateRandomString(max, maxChars, lower);

        String lcs = LCS.lcs(X, Y);
        System.out.println("LCS of " + X + ", " + Y + ": " + lcs);
    }
}
