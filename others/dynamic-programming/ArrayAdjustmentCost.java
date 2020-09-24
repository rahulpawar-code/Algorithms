/*
 * https://www.techiedelight.com/determine-minimal-adjustment-cost-array/
 */

import java.util.Random; // for test cases

class ArrayAdjustment {
    private static int minCostRec(int[] array, int target, int n) {
        if (n < 0) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        int original = array[n];
        for (int i = array[n + 1] - target; i <= array[n + 1] + target; ++i) {
            array[n] = i;
            int cost = minCostRec(array, target, n - 1);
            minCost = Math.min(minCost, cost + Math.abs(original - i));
            array[n] = original;
        }
        return minCost;
    }
    public static int minCostRec(int[] array, int target) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        return minCostRec(array, target, array.length - 2);
    }
}

class Driver {
    public static void main(String[] args) {
        int target = 1;
        int[] array = {1, 3, 0, 3};

        System.out.println("min cost: " + ArrayAdjustment.minCostRec(array, target));

        // int[] array2 = {55, 77, 52, 61, 39, 6, 25, 60, 49, 47};
        // int target2 = 10;
        // System.out.println("min cost: " + ArrayAdjustment.minCostRec(array2, target2));
    }
}
