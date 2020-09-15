/*
 * https://www.techiedelight.com/maximum-product-rod-cutting/
 */

import java.util.Random;

class RodCuttingProduct {
    private static void checkInputs(int[] array, int length) {
        if (length < 0 || array == null) {
            throw new IllegalArgumentException();
        }
    }

    private static int profitRec(int[] costArray, int n) {
        if (n <= 0) {
            return n + 1;
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i <= n; ++i) {
            int cost = costArray[i - 1] * profitRec(costArray, n - i);
            maxProfit = Math.max(maxProfit, cost);
        }
        return maxProfit;
    }

    public static int profitRecursive(int[] costArray, int length) {
        checkInputs(costArray, length);
        return profitRec(costArray, length);
    }


    public static int tabular(int[] costArray, int n) {
        checkInputs(costArray, n);
        int[] costTable = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            costTable[i] = costArray[i - 1];
        }

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                costTable[i] = Math.max(costTable[i], costArray[j - 1] * costTable[i - j]);
            }
        }
        return costTable[n];
    }
}


class Driver {
    private static int[] randomArray(int n, int max) {
        Random rand = new Random();
        int[] array = new int[n];

        for (int i = 0; i < n; ++i) {
            array[i] = rand.nextInt(max);
        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 6;
        int max = 9;
        int[] cost = randomArray(n, max);
        Driver.printArray(cost);

        int profit = RodCuttingProduct.profitRecursive(cost, cost.length);
        System.out.println("Max profit: ");
        System.out.println("Recursive : " + RodCuttingProduct.profitRecursive(cost, cost.length));
        System.out.println("Tabluar : " + RodCuttingProduct.tabular(cost, cost.length));
    }
}
