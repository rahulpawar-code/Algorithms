/*
 * https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 */

import java.util.Random;
import java.util.HashSet;
import java.util.Arrays;

class LCS {
    private static final int NO_OF_CHARS = 256;
    private static boolean areUnique(String X, int left, int right) {
        HashSet<Character> set = new HashSet<>();
        for (int i = left; i <= right; ++i) {
            if(set.contains(X.charAt(i))) {
                return false;
            }
            set.add(X.charAt(i));
        }
        return true;
    }

    public static String naive(String X) {
        if (X == null) {
            throw new IllegalArgumentException();
        }
        if (X.length() == 0) {
            return "";
        }

        int left = 0;
        int right = 0;
        int maxLength = 0;
        for (int i = 0; i < X.length(); ++i) {
            for (int j = i; j < X.length(); ++j) {
                if (areUnique(X, i, j) && (j - i + 1) > maxLength) {
                    left = i;
                    right = j;
                    maxLength = right - left + 1;
                }
            }
        }
        return X.substring(left, right + 1);
    }

    public static String slidingWindow(String X) {
        if (X == null) {
            throw new IllegalArgumentException();
        }
        if (X.length() == 0) {
            return "";
        }

        int[] index = new int[NO_OF_CHARS];
        Arrays.fill(index, - 1);

        int left = 0;
        int right = 0;
        int maxLength = 0;
        int i = 0;

        for (int j = 0; j < X.length(); ++j) {
            i = Math.max(i, index[X.charAt(j)] + 1);

            int length = j - i + 1;
            if (length > maxLength) {
                left = i;
                right = j;
                maxLength = length;
            }

            index[X.charAt(j)] = j;
        }
        return X.substring(left, right + 1);
    }
}

class Driver {
    private static String generateString(int length, char[] alphabet) {
        Random random = new Random();
        StringBuffer sb =  new StringBuffer();

        int n = alphabet.length;

        for (int i = 0; i < length; ++i) {
            int index = random.nextInt(n);
            sb.append(alphabet[index]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int length = 10;
        char[] alphabet = {'A', 'B', 'C', 'D', 'X', 'Y'};
        String X = Driver.generateString(length, alphabet);
        System.out.println("X : " + X);
        String n = LCS.naive(X);
        System.out.println("Using naive method : " + n);
        String sw = LCS.slidingWindow(X);
        System.out.println("Using sliding window method : " + sw);
    }
}
