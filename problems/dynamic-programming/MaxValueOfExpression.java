/*
 * https://www.techiedelight.com/maximize-value-of-the-expression/
 */

import java.util.Arrays;
import java.util.Random;
class MaxValueOfExpression {
    public static int maximizeExpression(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }

        int n = A.length;

        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        int[] third = new int[n + 1];
        int[] fourth = new int[n + 1];

        Arrays.fill(first, Integer.MIN_VALUE);
        Arrays.fill(second, Integer.MIN_VALUE);
        Arrays.fill(third, Integer.MIN_VALUE);
        Arrays.fill(fourth, Integer.MIN_VALUE);

        for (int i = n - 1; i >= 0; --i) {
            first[i] = Math.max(first[i + 1], A[i]);
        }

        for (int i = n - 2; i >= 0; --i) {
            second[i] = Math.max(second[i + 1], first[i + 1] - A[i]);
        }

        for (int i = n - 3; i >= 0; --i) {
            third[i] = Math.max(third[i + 1], second[i + 1] + A[i]);
        }

        for (int i = n - 4; i >= 0; --i) {
            fourth[i] = Math.max(fourth[i + 1], third[i + 1] - A[i]);
        }

        return fourth[0];
    }

    public static int maximizeExpression2(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException();
        }

        int n = a.length;
        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        int[] third = new int[n + 1];
        int[] fourth = new int[n + 1];
        Arrays.fill(first, Integer.MIN_VALUE);
        Arrays.fill(second, Integer.MIN_VALUE);
        Arrays.fill(third, Integer.MIN_VALUE);
        Arrays.fill(fourth, Integer.MIN_VALUE);

        for (int i = 1; i <= n; ++i) {
            first[i] = Math.max(first[i - 1], -a[i - 1]);
        }

        for (int i = 2; i <= n; ++i) {
            second[i] = Math.max(second[i - 1], first[i - 1] + a[i - 1]);
        }

        for (int i = 3; i <= n; ++i) {
            third[i] = Math.max(third[i - 1], second[i - 1] - a[i - 1]);
        }

        for (int i = 4; i <= n; ++i) {
            fourth[i] = Math.max(fourth[i - 1], third[i - 1] + a[i - 1]);
        }

        return fourth[n];
    }
}


class Driver {
    private static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] randomIntegerArray(int n, int max) {
        int[] a = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; ++i) {
            a[i] = rand.nextInt(max);
        }
        return a;
    }

    public static void main(String[] args) {
        int max = 10;
        int n = 5;
        int[] a = randomIntegerArray(n, max);
        printArray(a);

        int maximizeValue = MaxValueOfExpression.maximizeExpression(a);
        System.out.println("Right to left method : " + maximizeValue);

        maximizeValue = MaxValueOfExpression.maximizeExpression2(a);
        System.out.println("Left to right method : " + maximizeValue);
    }
}
