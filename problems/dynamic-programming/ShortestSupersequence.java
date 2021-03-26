/*
 * problem : https://www.techiedelight.com/shortest-common-supersequence-introduction-scs-length/
 */

import java.util.Random;

class ShortestSupersequence {
    private static void checkInputs(String X, String Y) {
        if (X == null || Y == null) {
            throw new IllegalArgumentException();
        }
    }

    private static int[][] length(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] table = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                }
            }
        }
        return table;
    }

    private static String sequence(String X, String Y, int[][] table) {
        int m = X.length();
        int n = Y.length();
        StringBuffer sb = new StringBuffer();

        while (m > 0 && n > 0) {
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                sb.append(X.charAt(m - 1));
                m--;
                n--;
            } else if (table[m - 1][n] > table[m][n - 1]) {
                sb.append(X.charAt(m - 1));
                m--;
            } else {
                sb.append(Y.charAt(n - 1));
                n--;
            }
        }
        while (m > 0) {
            sb.append(X.charAt(m - 1));
            m--;
        }
        while (n > 0) {
            sb.append(Y.charAt(n - 1));
            n--;
        }
        return sb.reverse().toString();
    }

    public static String sequence(String X, String Y) {
        checkInputs(X, Y);
        int[][] table = length(X, Y);
        return sequence(X, Y, table);
    }

    public static int lcsLength(String X, String Y) {
        checkInputs(X, Y);
        int[][] table = length(X, Y);
        return table[X.length()][Y.length()];
    }
}

class Driver {
    public static void main(String[] args) {
        int length = 4;
        String X = RandomString.nextString(length, RandomString.GENOME);
        String Y = RandomString.nextString(length, RandomString.GENOME);
        System.out.println("X : " + X);
        System.out.println("Y : " + Y);
        String s = ShortestSupersequence.sequence(X, Y);
        int lcslength = ShortestSupersequence.lcsLength(X, Y);
        System.out.println("Supersequence should be : " + (X.length() + Y.length() - lcslength));
        System.out.println("Supersequence length : " + s);
        System.out.println("Supersequence length : " + s.length());
    }
}
