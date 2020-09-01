/*
 * https://www.techiedelight.com/find-minimum-cost-reach-last-cell-matrix-first-cell/
 */

class MatrixMinCost {
    private static void checkInputs(int[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException();
        }
    }

    private static int minCostRecursive(int[][] mat, int m, int n) {
        if (m == 0 || n == 0) {
            return Integer.MAX_VALUE;
        }

        if (m == 1 && n == 1) {
            return mat[0][0];
        }

        return mat[m - 1][n - 1] + Math.min(minCostRecursive(mat, m - 1, n),
                                            minCostRecursive(mat, m, n - 1));
    }

    public static int minCostRecursive(int[][] mat) {
        checkInputs(mat);
        return minCostRecursive(mat, mat.length, mat[0].length);
    }

    public static int minCostTopDown(int[][] mat) {
        checkInputs(mat);
        int m = mat.length;
        int n = mat[0].length;
        int[][] cost = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                cost[i][j] = mat[i][j];

                if (i == 0 && j > 0) {
                    cost[i][j] += cost[i][j - 1];
                } else if (j == 0 && i > 0) {
                    cost[i][j] += cost[i - 1][j];
                } else if (i > 0 && j > 0) {
                    cost[i][j] += Math.min(cost[i - 1][j], cost[i][j - 1]);
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}

class Driver {
    public static void main(String[] args) {
        int rows = 8;
        int cols = 10;
        int min = 2;
        int max = 20;
        int[][] mat = Random2DMatrix.nextMatrix(rows, cols, min, max);
        Random2DMatrix.printMatrix(mat);

        System.out.println("===============================================");
        System.out.println("Min cost from top left to bottom right : " + MatrixMinCost.minCostRecursive(mat));
        System.out.println("Min cost from top left to bottom right : " + MatrixMinCost.minCostTopDown(mat));
    }
}
