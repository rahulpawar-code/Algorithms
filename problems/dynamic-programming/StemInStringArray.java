/*
 * Problem https://www.geeksforgeeks.org/longest-common-substring-array-strings/?ref=rp
 */

import java.util.Arrays;

class Stem {
    public static String findStem(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (array.length <= 0) {
            return "";
        }

        // Sort the input array because the stem will be substring of shortest string
        Arrays.sort(array);

        int n = array.length;
        String s = array[0];
        int sLength = s.length();
        String maxStem = "";

        // generate all substrings of s
        for (int i = 0; i < sLength; ++i) {
            for (int j = i + 1; j <= sLength; ++j) {
                String stem = s.substring(i, j);

                // Check this stem is substring of all strings in array
                int k = 1;
                for (k = 1; k < n; ++k) {
                    if (!array[k].contains(stem)) {
                        break;
                    }
                }

                // Check if this stem is largest
                if (k == n && stem.length() > maxStem.length()) {
                    maxStem = stem;
                }
            }
        }
        return maxStem;

    }
}

class StemInStringArray {
    public static void main(String[] args) {
        String[] array = {"grace", "gracefully", "graceful", "disgraceful"};
        String stem = Stem.findStem(array);
        System.out.println("Stem is : " + stem);
    }
}
