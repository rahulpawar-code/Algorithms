import java.util.Random;

// Assume rows x cols or m x n rectangular 2D matrix
class Random2DMatrix {
    private static void checkInputs(int rows, int cols) {
        if (rows < 0 || cols < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void printMatrix(boolean[][] mat) {
        for (int r = 0; r < mat.length; ++r) {
            for (int c = 0; c < mat[r].length; ++c) {
                System.out.printf("%-6b", mat[r][c]);
            }
            System.out.println("");
        }
    }

    public static void printMatrix(int[][] mat) {
        for (int r = 0; r < mat.length; ++r) {
            for (int c = 0; c < mat[r].length; ++c) {
                System.out.printf("%-6d", mat[r][c]);
            }
            System.out.println("");
        }
    }

    public static int[][] nextMatrix(int rows, int cols, int lower, int higher) {
        checkInputs(rows, cols);
        int[][] mat = new int[rows][cols];
        Random random = new Random();

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                mat[r][c] = lower + random.nextInt(higher - lower + 1);
            }
        }

        return mat;
    }

    public static int[][] nextMatrix(int rows, int cols, int differentValues) {
        checkInputs(rows, cols);
        return nextMatrix(rows, cols, 1, differentValues);
    }

    public static int[][] nextBinaryMatrix(int rows, int cols) {
        checkInputs(rows, cols);
        return nextMatrix(rows, cols, 0, 1);
    }

    public static boolean[][] nextBooleanMatrix(int rows, int cols) {
        checkInputs(rows, cols);

        boolean[][] mat = new boolean[rows][cols];
        Random random = new Random();

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                mat[r][c] = random.nextBoolean();
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        boolean[][] mat = Random2DMatrix.nextBooleanMatrix(5, 4);
        Random2DMatrix.printMatrix(mat);

        System.out.println("=================================");

        int[][] binaryMat = Random2DMatrix.nextBinaryMatrix(6, 5);
        Random2DMatrix.printMatrix(binaryMat);

        System.out.println("=================================");

        int[][] mat2 = Random2DMatrix.nextBinaryMatrix(6, 7);
        Random2DMatrix.printMatrix(mat2);

        System.out.println("=================================");

        int[][] mat3 = Random2DMatrix.nextMatrix(6, 7, 4);
        Random2DMatrix.printMatrix(mat3);

        System.out.println("=================================");

        int[][] mat4 = Random2DMatrix.nextMatrix(6, 7, 10, 20);
        Random2DMatrix.printMatrix(mat4);
    }
}
