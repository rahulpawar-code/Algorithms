/*
 * https://www.techiedelight.com/total-ways-sum-with-n-throws-dice-having-k-faces/
 */

class DiceThrow {
    public static int waysRec(int n, int k, int sum) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }

        if (sum < 0 || n * k < sum || n > sum) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i <= k; ++i) {
            count += waysRec(n - 1, k, sum - i);
        }
        return count;
    }

    private static int waysTabular(int n, int k, int sum, int[][] lookup) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }

        if (sum < 0 || n * k < sum || n > sum) {
            return 0;
        }

        if (lookup[n][sum] == 0) {
            for (int i = 1; i <= k; ++i) {
                lookup[n][sum] += waysTabular(n - 1, k, sum - i, lookup);
            }
        }

        return lookup[n][sum];
    }

    public static int waysTabular(int n, int k, int sum) {
        int[][] lookup = new int[n + 1][sum + 1];
        return waysTabular(n, k, sum, lookup);
    }
}

class Driver {
    public static void main(String[] args) {
        int sum = 15;
        int n = 4;
        int k = 6;

        System.out.println("No of ways : " + DiceThrow.waysRec(n, k, sum));
        System.out.println("No of ways : " + DiceThrow.waysTabular(n, k, sum));
    }
}
