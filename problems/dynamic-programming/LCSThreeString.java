/*
 * https://www.techiedelight.com/longest-common-subsequence-of-k-sequences/
 * https://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/
 */

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

class LCS {
    private static void checkInput(String X, String Y, String Z) {
        if (X == null || Y == null || Z == null) {
            throw new IllegalArgumentException();
        }
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private static int TopDown(String X, String Y, String Z, int i, int j,
                                int k, Map<String, Integer> map) {
        if (i == 0 || j == 0 || k == 0) {
            return 0;
        }

        String key = i + "|" + j + "|" + k;
        if (!map.containsKey(key)) {
            if (X.charAt(i - 1) == Y.charAt(j - 1) &&
                    Y.charAt(j - 1) == Z.charAt(k - 1)) {
                int len = TopDown(X, Y, Z, i - 1, j - 1, k - 1, map);
                map.put(key, len + 1);
            } else {
                map.put(key, max(TopDown(X, Y, Z, i - 1, j, k, map),
                                 TopDown(X, Y, Z, i, j - 1, k, map),
                                 TopDown(X, Y, Z, i, j, k - 1, map)));
            }
        }

        return map.get(key);

    }

    public static int TopDown(String X, String Y, String Z) {
        checkInput(X, Y, Z);
        Map<String, Integer> map = new HashMap<>();
        return TopDown(X, Y, Z, X.length(), Y.length(), Z.length(), map);
    }

    public static int BottomUp(String X, String Y, String Z) {
        checkInput(X, Y, Z);
        int m = X.length();
        int n = Y.length();
        int o = Z.length();
        int[][][] table = new int[m + 1][n + 1][o + 1];

        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                for (int k = 0; k <= o; ++k) {
                    if (i == 0 || j == 0 || k == 0) {
                        table[i][j][k] = 0;
                    } else if (X.charAt(i - 1) == Y.charAt(j - 1) &&
                            Y.charAt(j - 1) == Z.charAt(k - 1)) {
                        table[i][j][k] = table[i - 1][j - 1][k - 1] + 1;
                    } else {
                       table[i][j][k] = max(table[i - 1][j][k],
                                            table[i][j - 1][k],
                                            table[i][j][k - 1]);
                    }
                }
            }
        }
        return table[m][n][o];
    }

    private static int recursive(String X, String Y, String Z, int m,
                        int n, int o) {
        if (m == 0 || n == 0 || o == 0) {
            return 0;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1) &&
                Y.charAt(n - 1) == Z.charAt(o - 1)) {
            return 1 + recursive(X, Y, Z, m - 1, n - 1, o - 1);
        }

        return max(recursive(X, Y, Z, m - 1, n, o),
                recursive(X, Y, Z, m, n - 1, o),
                recursive(X, Y, Z, m, n, o - 1));
    }

    public static int Recursive(String X, String Y, String Z) {
        checkInput(X, Y, Z);
        return recursive(X, Y, Z, X.length(), Y.length(), Z.length());
    }
}

class LCSThreeString {
    private static String generateRandomString(int maxlength, int maxChars, int lower) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        int length = random.nextInt(maxlength + 1);

        for (int i = 0 ; i < length; ++i) {
            int next = lower + random.nextInt(maxChars);
            sb.append((char)next);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int length = 8;
        int maxChars = 5;
        int lower = 65;

        String X = LCSThreeString.generateRandomString(length, maxChars, lower);
        String Y = LCSThreeString.generateRandomString(length, maxChars, lower);
        String Z = LCSThreeString.generateRandomString(length, maxChars, lower);

        System.out.println("X : " + X);
        System.out.println("Y : " + Y);
        System.out.println("Z : " + Z);

        int lcsLength = LCS.TopDown(X, Y, Z);
        System.out.println("Length using top down method : " + lcsLength);
        lcsLength = LCS.BottomUp(X, Y, Z);
        System.out.println("Length using bottom up method : " + lcsLength);
        lcsLength = LCS.Recursive(X, Y, Z);
        System.out.println("Length using recursive method : " + lcsLength);
    }
}
