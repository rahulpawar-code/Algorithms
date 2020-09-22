/*
 * https://www.techiedelight.com/coin-change-problem-find-total-number-ways-get-denomination-coins/
 */

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

class CoinChangeWays {
    private static void checkInput(int[] coins) {
        if (coins == null) {
            throw new IllegalArgumentException();
        }
    }

    private static int incorrectRec(int[] coins, int changeValue) {
        if (changeValue == 0) {
            return 1;
        }

        if (changeValue < 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < coins.length; ++i) {
            res += incorrectRec(coins, changeValue - coins[i]);
        }
        return res;
    }

    public static int incorrect(int[] coins, int changeValue) {
        checkInput(coins);
        return incorrectRec(coins, changeValue);
    }

    private static int correctRec(int[] coins, int changeValue, int n) {
        if (changeValue == 0) {
            return 1;
        }

        if (changeValue < 0 || n < 0) {
            return 0;
        }

        return correctRec(coins, changeValue, n -1) +
               correctRec(coins, changeValue - coins[n], n);
    }

    public static int correct(int[] coins, int changeValue) {
        checkInput(coins);
        return correctRec(coins, changeValue, coins.length - 1);
    }

    private static int memoization(int[] coins, int changeValue, int n,
                                   Map<String, Integer> lookup) {
        if (changeValue == 0) {
            return 1;
        }

        if (changeValue < 0 || n < 0) {
            return 0;
        }

        String key = n + " | " + changeValue;
        if (!lookup.containsKey(key)) {
            int include = memoization(coins, changeValue - coins[n], n, lookup);
            int exclude = memoization(coins, changeValue, n - 1, lookup);
            lookup.put(key, include + exclude);
        }

        return lookup.get(key);
    }

    public static int topDown(int[] coins, int changeValue) {
        checkInput(coins);
        Map<String, Integer> lookup = new HashMap<>();
        return memoization(coins, changeValue, coins.length - 1, lookup);
    }
}

class Driver {
    private static void printArray(int[] array) {
        for (int a: array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    private static int[] randomArray(int n, int max) {
        Random random = new Random();
        int[] array = new int[n];

        for (int i = 0; i < n; ++i) {
            array[i] = random.nextInt(max) + 1;
        }
        return array;
    }

    public static void main(String[] args) {
        int n = 4;
        int max = 10;
        int changeValue = 17;
        int[] coins = Driver.randomArray(n, max);

        System.out.print("Coins : ");
        Driver.printArray(coins);
        System.out.println("Change value: " + changeValue);

        System.out.println("\nNo. of ways to make change using methods -");
        System.out.println("Incorrect recursive : " + CoinChangeWays.incorrect(coins, changeValue));
        System.out.println("Correct recursive : " + CoinChangeWays.correct(coins, changeValue));
        System.out.println("Top down memoization: " + CoinChangeWays.topDown(coins, changeValue));
    }
}
