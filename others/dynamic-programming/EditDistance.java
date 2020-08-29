/*
 * https://www.techiedelight.com/levenshtein-distance-edit-distance-problem/
 */

class EditDistance {
    private static void checkInputs(String X, String Y) {
        if (X == null || Y == null) {
            throw new IllegalArgumentException();
        }
    }

    private static int min(int a, int b) {
        return Math.min(a, b);
    }

    private static int min(int a, int b, int c) {
        return min(a, min(b, c));
    }

    private static int recursion(String X, String Y, int m, int n) {
        if (m == 0 || n == 0) {
            return m + n;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return recursion(X, Y, m - 1, n - 1);
        }

        return 1 + min(recursion(X, Y, m - 1, n),
                       recursion(X, Y, m - 1, n - 1),
                       recursion(X, Y, m, n - 1));
    }

    public static int recursion(String X, String Y) {
        checkInputs(X, Y);
        return recursion(X, Y, X.length(), Y.length());
    }

    public static int bottomUp(String X, String Y) {
        checkInputs(X, Y);

        int m = X.length();
        int n = Y.length();
        int[][] table = new int[m + 1][n + 1];

        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                int value = 0;
                if (i == 0 || j == 0) {
                    value = i + j;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    value = table[i - 1][j - 1];
                } else {
                    value = 1 + min(table[i - 1][j], table[i - 1][j - 1],
                                    table[i][j - 1]);
                }
                table[i][j] = value;
            }
        }

        return table[m][n];
    }
}

class Driver {
    public static void main(String[] args) {
        int lengthX = 10;
        int lengthY = 8;
        char[] alphabets = {'A', 'B', 'C', 'D', 'E'};
        String X = RandomString.nextString(lengthX, alphabets);
        String Y = RandomString.nextString(lengthX, alphabets);

        System.out.println("X : " + X);
        System.out.println("Y : " + Y);

        System.out.println("Edit distance - ");
        System.out.println("Using recursion : " + EditDistance.recursion(X, Y));
        System.out.println("Using bottomUp : " + EditDistance.bottomUp(X, Y));

        System.out.println("===========================");

        X = "kitten";
        Y = "sitting";

        System.out.println("X : " + X);
        System.out.println("Y : " + Y);

        System.out.println("Edit distance - ");
        System.out.println("Using recursion : " + EditDistance.recursion(X, Y));
        System.out.println("Using bottomUp : " + EditDistance.bottomUp(X, Y));
    }
}
