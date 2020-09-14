/*
 * https://www.techiedelight.com/3-partition-problem/
 */
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

class ThreePartition {
    private static void checkInput(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException();
        }
    }

    private static int arraySum(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    public static boolean recursive(int[] a) {
        int sum = arraySum(a);
        if (a.length <= 2 || (sum % 3 != 0))  {
            return false;
        }

        return recursive(a, a.length - 1, sum / 3, sum / 3, sum /3);
    }

    private static boolean recursive(int[] a, int n, int sumA, int sumB, int sumC) {
        if (sumA == 0 && sumB == 0 && sumC == 0) {
            return true;
        }

        if (sumA < 0 || sumB < 0 || sumC < 0) {
            return false;
        }

        if (n < 0) {
            return false;
        }

        return recursive(a, n - 1, sumA - a[n], sumB, sumC) ||
               recursive(a, n - 1, sumA, sumB - a[n], sumC) ||
               recursive(a, n - 1, sumA, sumB, sumC - a[n]);
    }

    public static boolean topDown(int[] a) {
        int sum = arraySum(a);
        if (a.length <= 2 || (sum % 3 != 0))  {
            return false;
        }

        Map<String, Boolean> lookup = new HashMap<>();
        return topDown(a, a.length - 1, sum / 3, sum / 3, sum /3, lookup);
    }

    private static boolean topDown(int[] a, int n, int sumA, int sumB, int sumC,
                                   Map<String, Boolean> lookup) {
        if (sumA == 0 && sumB == 0 && sumC == 0) {
            return true;
        }

        if (sumA < 0 || sumB < 0 || sumC < 0) {
            return false;
        }

        if (n < 0) {
            return false;
        }

        String key = sumA + "|" + sumB + "|" + sumC + "|" + n;
        if (!lookup.containsKey(key)) {
            boolean includeInSetA = topDown(a, n - 1, sumA - a[n], sumB, sumC, lookup);
            boolean includeInSetB = topDown(a, n - 1, sumA, sumB - a[n], sumC, lookup);
            boolean includeInSetC = topDown(a, n - 1, sumA, sumB, sumC - a[n], lookup);
            lookup.put(key, includeInSetA || includeInSetB || includeInSetC);
        }

        return lookup.get(key);
    }
}

class Driver {
    private static int[] randomArray(int n, int max) {
        int[] a = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; ++i) {
            a[i] = rand.nextInt(max);
        }
        return a;
    }

    private static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void test() {
        int maxN = 20;
        int maxRange = 30;
        for (int i = 0; i <= maxN; ++i) {
            for (int j = 1; j <= maxRange; ++j) {
                int[] a = Driver.randomArray(i, j);
                boolean method1 = ThreePartition.recursive(a);
                boolean method2 = ThreePartition.topDown(a);
                if (method1 != method1) {
                    System.out.print("Test failed for input: ");
                    printArray(a);
                    System.out.println("Recursive : " + method1 + ", top down" + method2);
                }
            }
        }
    }

    public static void main(String[] args) {
        test();
        int n = 10;
        int max = 10;
        int[] a = Driver.randomArray(n, max);
        Driver.printArray(a);

        System.out.println("Partition in 3 sets with equal sum: ");
        System.out.println("Using recursive method : " + ThreePartition.recursive(a));
        System.out.println("Using top down method : " + ThreePartition.topDown(a));
    }
}
