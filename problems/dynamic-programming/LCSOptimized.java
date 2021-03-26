/*
 * Problem : https://www.geeksforgeeks.org/space-optimized-solution-lcs/
 * https://www.techiedelight.com/longest-common-subsequence-lcs-space-optimized-version/
 */

import java.util.Random;

class LCS {
    // Using 2 arrays
    public static int twoArrayMethod(String X, String Y) {
        if (X == null || Y == null) {
            throw new IllegalArgumentException();
        }

        int m = X.length();
        int n = Y.length();

        int[][] table = new int[2][n + 1];
        int indexSwitch = 0;

        for (int i = 0; i <= m; ++i) {
            indexSwitch = indexSwitch & i;
            for (int j = 0; j <= n; ++j) {
                if (i == 0 || j == 0) {
                    table[indexSwitch][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    table[indexSwitch][j] = table[1 - indexSwitch][j - 1] + 1;
                } else {
                    table[indexSwitch][j] = Math.max(table[1 - indexSwitch][j], table[indexSwitch][j - 1]);
                }
            }
        }
        return table[indexSwitch][n];
    }

    // Using single array
    public static int oneArrayMethod(String X, String Y) {
        if (X == null || Y == null) {
            throw new IllegalArgumentException();
        }

        int m = X.length();
        int n = Y.length();
        int[] table = new int[n + 1];

        for (int i = 0; i <= m; ++i) {
            int previous = table[0];
            for (int j = 0; j <= n; ++j) {
                int backup = table[j];
                if (i == 0 || j == 0) {
                    table[j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    table[j] = previous + 1;
                } else {
                    table[j] = Math.max(table[j], table[j - 1]);
                }
                previous = backup;
            }
        }

        return table[n];
    }
}

class LCSOptimized {
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
        int max = 5;       // max length of string
        int maxChars = 4;  // only 6 chars
        int lower = 65; // ascii value of upper case A

        String X = generateRandomString(max, maxChars, lower);
        String Y = generateRandomString(max, maxChars, lower);
        System.out.println("X : " + X);
        System.out.println("Y : " + Y);

        int length = LCS.twoArrayMethod(X, Y);
        System.out.println("LCS length from 2 array method : " + length);
        length = LCS.oneArrayMethod(X, Y);
        System.out.println("LCS length from 1 array method : " + length);
    }
}
