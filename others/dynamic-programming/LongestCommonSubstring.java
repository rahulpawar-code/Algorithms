/*
 * https://www.techiedelight.com/longest-common-substring-problem/
 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 */

import java.util.Random; // For generating random strings

class LCS {
    // Validate 2 input strings
    private static void checkInputs(String X, String Y) {
        if (X == null || Y == null) {
            throw new IllegalArgumentException();
        }
    }

    // Max of 3 numbers
    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // Recursive function getting count in top down fashion
    private static int recursive(String X, String Y, int m,
                                    int n, int count) {
        if (m == 0 || n == 0) {
            return count;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            count = recursive(X, Y, m - 1, n - 1, 1 + count);
        }

        int countL = recursive(X, Y, m - 1, n, 0);
        int countR = recursive(X, Y, m, n - 1, 0);
        return max(count, countL, countR);
    }

    public static int recursive(String X, String Y) {
        checkInputs(X, Y);
        return recursive(X, Y, X.length(), Y.length(), 0);
    }


    // Space optimized bottom up version using 2 arrays
    public static int spaceOptimized(String X, String Y) {
        checkInputs(X, Y);
        int m = X.length();
        int n = Y.length();
        int[][] table = new int[2][n + 1];
        int indexSwitch = 0; // odd and even index switch for first dim of table
        int max = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 || j == 0) {
                    table[indexSwitch][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    table[indexSwitch][j] = 1 + table[1 - indexSwitch][j - 1];
                    max = Math.max(max, table[indexSwitch][j]);
                } else {
                    table[indexSwitch][j] = 0;
                }
            }
            indexSwitch =  1 - indexSwitch;
        }

        return max;
    }

    // Bottom up method, creating a lookup table
    public static int BottomUp(String X, String Y) {
        checkInputs(X, Y);
        int m = X.length();
        int n = Y.length();
        int max = 0;
        int[][] lookup = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lookup[i][j] = 1 + lookup[i - 1][j - 1];
                    max = Math.max(max, lookup[i][j]);
                }
            }
        }
        return max;
    }

    // Print the longest common substring. Logic is similar to bottom up method
    // Only diff is that now an additional index to row or col number is stored
    // at which current solution is max
    public static String printLongestCommonSubstring(String X, String Y) {
        checkInputs(X, Y);
        int m = X.length();
        int n = Y.length();
        int max = 0;
        int[][] lookup = new int[m + 1][n + 1];
        int endIndex = -1;

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lookup[i][j] = 1 + lookup[i - 1][j - 1];

                    if (lookup[i][j] > max) {
                        max = lookup[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        return X.substring(endIndex - max, endIndex);
   }
}

public class LongestCommonSubstring {
    // Generate random string of length using character from given alphabet
    private static String generateString(int length, char[] alphabet) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        int n = alphabet.length;

        for (int i = 0; i < length; ++i) {
            int nextIndex = random.nextInt(n);
            sb.append(alphabet[nextIndex]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int length = 10;
        char[] alphabets = {'A', 'B', 'C', 'D', 'X', 'Y'};

        String X = LongestCommonSubstring.generateString(length, alphabets);
        String Y = LongestCommonSubstring.generateString(length, alphabets);
        System.out.println("X : " + X);
        System.out.println("Y : " + Y);

        int max = LCS.BottomUp(X, Y);
        System.out.println("Longest common substring using bottom up method : " + max);
        max = LCS.recursive(X, Y);
        System.out.println("Longest common substring using recursive method : " + max);
        max = LCS.spaceOptimized(X, Y);
        System.out.println("Longest common substring using space optimized method : " + max);
        System.out.println("Longest common substring : " + LCS.printLongestCommonSubstring(X, Y));
    }
}
