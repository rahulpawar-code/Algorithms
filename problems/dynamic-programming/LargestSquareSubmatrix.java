/*
 * Problem https://www.techiedelight.com/find-size-largest-square-sub-matrix-1s-present-given-binary-matrix/
 */


class LargestSquareSubmatrix {
    private static void checkInputs(int[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException();
        }
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static int submatrix(int[][] mat) {
        checkInputs(mat);

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] S = new int[rows][cols];
        int maxSize = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; ++c) {
                S[r][c] = mat[r][c];

                if (r > 0 && c > 0 && mat[r][c] == 1) {
                    S[r][c] = 1 + min(mat[r - 1][c - 1],
                                      mat[r - 1][c],
                                      mat[r][c - 1]);
                    maxSize = Math.max(maxSize, S[r][c]);
                }
            }
        }
        return maxSize;
    }
}


class Driver {
    public static void main(String[] args) {
        int rows = 20;
        int cols = 15;
        int[][] mat = Random2DMatrix.nextBinaryMatrix(rows, cols);
        System.out.println("Binary matrix : ");
        Random2DMatrix.printMatrix(mat);

        System.out.println("\nLargest square submatrix of 1\'s is : ");
        System.out.println("Size : " + LargestSquareSubmatrix.submatrix(mat));
    }
}
