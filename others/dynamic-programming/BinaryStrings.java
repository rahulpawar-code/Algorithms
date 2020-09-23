/*
 * https://www.techiedelight.com/find-n-digit-binary-strings-without-consecutive-1s/
 */

class BinaryString {
    public static void printString(String out, int n, int lastDigit) {
        if (n == 0) {
            System.out.println(out);
            return;
        }

        printString(out + "0", n - 1, 0);

        if (lastDigit == 0) {
            printString(out + "1" , n - 1, 1);
        }
    }

    public static int countStringTable(int n) {
        int[][] T = new int[n][2];
        T[0][0] = 1;
        T[0][1] = 1;

        for (int i = 1; i < n; ++i) {
            T[i][1] = T[i - 1][0];
            T[i][0] = T[i - 1][0] + T[i - 1][1];
        }

        return T[n - 1][0] + T[n - 1][1];
    }

    public static int countString(int n, int lastDigit) {
        if (n <= 0) {
            return 1;
        }

        if (lastDigit == 1) {
            return countString(n - 1, 0);
        } else {
            return countString(n - 1, 0) + countString(n - 1, 1);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Number of " + n + "-digit binary string without" +
            " consecutive 1's using method");
        System.out.println("Recursion : " + BinaryString.countString(n, 0));
        System.out.println("Bottom up : " + BinaryString.countStringTable(n));
        System.out.println("\nString :");
        BinaryString.printString("", n, 0);
    }
}
