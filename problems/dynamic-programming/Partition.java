/*
 * https://www.techiedelight.com/partition-problem/
 */

import java.util.Random;

class Partition {
    private static boolean subsetSumRecursive(int[] a, int n, int sum) {
        if (sum == 0) {
            return true;
        }

        if (n < 0 || sum < 0) {
            return false;
        }

        return subsetSumRecursive(a, n - 1, sum) || subsetSumRecursive(a, n - 1, sum - a[n]);
    }

    public static boolean subsetSumRecursive(int[] a) {
        int sum = 0;
        for (int x : a) {
            sum += x;
        }

        return ((sum & 1) == 0) && subsetSumRecursive(a, a.length - 1, sum / 2);
    }

    public static boolean subsetSumIterative(int[] a) {
        int sum = 0;
        for (int x : a) {
            sum += x;
        }
        if ((sum & 1) != 0) {
            return false;
        }

        sum = sum / 2;
        int n = a.length;
        boolean[][] table = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; ++i) {
            table[i][0] = true;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (j - a[i - 1] < 0) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = table[i - 1][j] || table[i - 1][j - a[i - 1]];
                }
            }
        }
        return table[n][sum];
    }
}

class Driver {
    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] randomArray(int n, int max) {
        int[] a = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; ++i) {
            a[i] = rand.nextInt(max);
        }
        return a;
    }

    public static void main(String[] args) {
        int max = 20;
        int n = 8;
        int[] a = randomArray(n, max);
        print(a);
        System.out.println("Partition int two sets of equal sum");
        System.out.println("Using recusrion : " + Partition.subsetSumRecursive(a));
        System.out.println("Using iterative : " + Partition.subsetSumIterative(a));
    }
}
