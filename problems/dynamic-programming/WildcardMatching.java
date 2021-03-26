/*
 * https://www.techiedelight.com/wildcard-pattern-matching/
 */

class WildcardMatching {
    private static void checkInputs(String string, String pattern) {
        if (string == null || pattern == null) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isMatchingRec(String string, String pattern,
                    int m, int n, boolean[][] lookup) {
        if (m < 0 && n < 0) {
            // string and pattern exhausted, is a match
            return true;
        } else if (n < 0) {
            // pattern exhausted, not a match
            return false;
        } else if (m < 0) {
            // string exhausted, match only if all remaining string is "*"
            for (int i = 0; i <= n; ++i) {
                if (pattern.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        // Problem not seen before
        if (!lookup[m][n]) {
            char p = pattern.charAt(n);
            char s = string.charAt(m);

            // 1. "*" in pattern matches to string current character
            // 2. Ignore "*" and move to next character in string
            if (p == '*') {
                lookup[m][n] = isMatchingRec(string, pattern, m - 1, n - 1, lookup) ||
                                isMatchingRec(string, pattern, m - 1, n, lookup);
            } else if (p != '?' && p != s) {
                // If "?" then ignore current string character
                lookup[m][n] = false;
            } else {
                // Current character in string should match with current pattern character
                lookup[m][n] = isMatchingRec(string, pattern, m - 1, n - 1, lookup);
            }

        }

        return lookup[m][n];
    }

    public static boolean isMatching(String string, String pattern) {
        checkInputs(string, pattern);
        boolean[][] lookup = new boolean[string.length() + 1][pattern.length() + 1];
        return isMatchingRec(string, pattern,
                string.length() - 1, pattern.length() - 1, lookup);
    }

    public static boolean isMatchingtableabular(String string, String pattern) {
        checkInputs(string, pattern);

        int m = string.length();
        int n = pattern.length();
        boolean[][] table = new boolean[m + 1][n + 1];

        // Both string and pattern are "", a match
        table[0][0] = true;

        // string is empty, then all pattern character should be "*" for a match
        for (int j = 1; j <= n; ++j) {
            if (pattern.charAt(j - 1) == '*') {
                table[0][j] = table[0][j - 1];
            }
        }

        for (int i = 1; i <= m; ++i) {
            char s = string.charAt(i - 1);
            for (int j = 1; j <= n; ++j) {
                char p = pattern.charAt(j - 1);
                if (p == '*') {
                    table[i][j] = table[i - 1][j - 1] || table[i - 1][j];
                } else if (p == '?' || (p == s)) {
                    table[i][j] = table[i - 1][j - 1];
                }
            }
        }

        return table[m][n];
    }
}

class Driver {
    public static void main(String[] args) {
        String string = "xyxzzxy";
        String pattern = "x***x?";
        System.out.println("Is matching : " + WildcardMatching.isMatching(string, pattern));
        System.out.println("Is matching : " + WildcardMatching.isMatchingtableabular(string, pattern));
    }
}
