import java.util.*;

public class Vestigium {
    // Function to check the validity of matrix
    private static void trace(int mat[][], int N) {
        int trace = 0;

        // Calculate trace
        for (int i = 0; i < N; ++i) {
            trace += mat[i][i];
        }

        // Row order scan to count repeated elements
        int rowCount = 0;
        for (int r = 0; r < N; ++r) {
            // Array to maintain frequency of each element
            int frequency[] = new int[N];
            for (int c = 0; c < N; ++c) {
                frequency[mat[r][c] - 1]++;
                if (frequency[mat[r][c] - 1] > 1) {
                    // repeated element
                    rowCount++;
                    break;
                }
            }
        }

        // Column order scan to count repeated elements
        int colCount = 0;
        for (int c = 0; c < N; ++c) {
            // Array to maintain frequency of each element
            int frequency[] = new int[N];
            for (int r = 0; r < N; ++r) {
                frequency[mat[r][c] - 1]++;
                if (frequency[mat[r][c] - 1] > 1) {
                    // repeated element
                    colCount++;
                    break;
                }
            }
        }

        // Print result
        System.out.println(trace + " " + rowCount + " " + colCount);
    }

    // Helper function to call comptuing function and print result in desired format
    private static void executeTestCase(int mat[][], int N, int t) {
        if (mat == null || (mat.length != mat[0].length) ||
            (mat.length != N)) {
            return;
        }

        System.out.print("Case #" + t + ": ");
        trace(mat, N);
    }

    public static void main(String []args){
        // Read inputs
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            for (int r = 0; r < n; ++r) {
                for (int c = 0; c < n; ++c) {
                    mat[r][c] = sc.nextInt();
                }
            }
            // Call helper method
            executeTestCase(mat, n, i);
        }
    }
}
