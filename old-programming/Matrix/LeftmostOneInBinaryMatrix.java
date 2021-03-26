package Matrix;

public class LeftmostOneInBinaryMatrix {
	private static int getLeftmostOne(int[][] matrix) {
		if (matrix == null) {
			return -1;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int index = -1;
		
		for (int i = 0; i < rows; ++i) {
			int j = (index != -1) ? index : cols - 1;
			for (; j >= 0; --j) {
				if (matrix[i][j] == 1) {
					index = j;
				}
			}
		}
		
		return index;
	}
	
	private static void testFunction(int[][] matrix, int expected, int i) {
		if (getLeftmostOne(matrix) == expected) {
			System.out.println("Test case " + i + "  passed");
		} else {
			System.out.println("Test case" + i + "  failed");
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix1 = {{0, 0, 0, 0, 0, 1},
						   {0, 0, 0, 0, 1, 1},
						   {0, 0, 0, 0, 1, 1},
						   {0, 0, 0, 0, 1, 1},
						   {0, 0, 0, 0, 1, 1}};
		int expected1 = 4;
		
		int[][] matrix2 = null;
		int expected2 = -1;
		
		testFunction(matrix1, expected1, 1);
		testFunction(matrix2, expected2, 2);
		
	}
}
