package Matrix;

public class TiledMultiplication {
	public static int[][] tiledMultiply(int A[][], int B[][], int tileSize[]) {
		if (A == null || B == null || tileSize[0] <= 0 || tileSize[1] <= 0 || A[0].length != B.length) {
			return null;
		}
		
		int m = A.length;
		int n = A[0].length;
		int p = B[0].length;
		int r = tileSize[0];
		int s = tileSize[1];
		
		int C[][] = new int[m][p];		
		
		for (int tiles = 0; tiles < (m*p) / (r*s); ++tiles) {
			for (int i = (int) (r*(tiles%Math.ceil(m/r))); i < r+r*(tiles%Math.ceil(m/r)) && i < m; ++i) {
				for (int j = (int)(s * tiles / Math.ceil(m/r)); j < s + (int)(s * tiles / Math.ceil(m/r)) && j < p; ++j) {
					for (int k = 0; k < n; ++k) {
						C[i][j] += A[i][k] * B[k][j];
					}
				}
			}
		}
		
		return C;
	}
	
	public static int[][] multiply(int A[][], int B[][]) {
		int C[][] = new int[A.length][B[0].length];
		for (int i=0; i < A.length; i++) {
		    for (int j=0; j < B[0].length; j++) {
		        for (int k = 0; k < B.length; ++k)
		        	C[i][j] += A[i][k] * B[k][j]; 
		    }           
		}
		return C;
	}
	
	public static void printMatrix(int C[][]) {
		for(int i = 0; i < C.length; ++i) {
			for (int j = 0; j < C[0].length; ++j) {
				System.out.print(String.format("%4s ",C[i][j]));
			}
			System.out.println("");
		}
	}
	
	public static int[][] getRandomMatrix(int rows, int coulmns) {
		int[][] matrix = new int[rows][coulmns];
		for (int i=0; i < matrix.length; i++) {
		    for (int j=0; j< matrix[i].length; j++) {
		        matrix[i][j] = (int) (Math.random()*10 + 1);
		    }           
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 30;
		int n = 30;
		int[][] A = getRandomMatrix(m, n);
		System.out.println("A: ");
		printMatrix(A);
		System.out.println("");
		
		int p = 30;
		int[][] B = getRandomMatrix(n, p);
		System.out.println("B: ");
		printMatrix(B);
		System.out.println("");
		
		int[] tileSize = {10, 10};
        int[][] C = tiledMultiply(A, B, tileSize);
        System.out.println("C: ");
		printMatrix(C);
		System.out.println("");
		
        int[][] D = multiply(A, B);
        System.out.println("D: ");
		printMatrix(D);
		System.out.println("");
		
	}
}
