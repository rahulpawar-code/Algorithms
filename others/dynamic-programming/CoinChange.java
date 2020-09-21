/*
 * https://www.techiedelight.com/coin-change-making-problem-unlimited-supply-coins/
 */

import java.util.Random;

class CoinChange {
    private static void checkInput(int[] coins) {
        if (coins == null) {
            throw new IllegalArgumentException();
        }
    }

    private static int recursiveInt(int[] coins, int changeValue) {
        if (changeValue == 0) {
            return 0;
        }

        if (changeValue < 0) {
            return Integer.MAX_VALUE;
        }

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; ++i) {
            int num = recursiveInt(coins, changeValue - coins[i]);

            if (num != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, num + 1);
            }
        }
        return minCoins;
    }

    public static int recursive(int[] coins, int changeValue) {
        checkInput(coins);
        return recursiveInt(coins, changeValue);
    }

    public static int bottomUp(int[] coins, int changeValue) {
        checkInput(coins);
        int[] T = new int[changeValue + 1];

        for (int i = 1; i <= changeValue; ++i) {
            T[i] = Integer.MAX_VALUE;
            int minCoins = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; ++j) {
                if (i - coins[j] >= 0) {
                    minCoins = T[i - coins[j]];
                }
                if (minCoins != Integer.MAX_VALUE) {
                    T[i] = Math.min(T[i], minCoins + 1);
                }
            }
        }

        return T[changeValue];
    }

}


class Driver {
    private static int[] randomArray(int n, int max) {
        int[] array = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; ++i) {
            array[i] = 1 + random.nextInt(max);
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
        int max = 9;
        int n = 5;
        int changeValue = 23;
        int[] coins = Driver.randomArray(n, max);

        Driver.printArray(coins);
        System.out.println("Number of coins required using method: ");
        System.out.println("Recursive: " + CoinChange.recursive(coins, changeValue));
        System.out.println("bottom up: " + CoinChange.bottomUp(coins, changeValue));
    }
}
