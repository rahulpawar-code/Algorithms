package DynamicProgramming;

public class LongestIncreasingSequence {
	private static int lis(int arr[], int n) {
		if (n == 0) {
			return 1;
		}
		
		int max = 0;
		for (int i = 0; i <= n - 1; ++i) {
			int res = lis(arr, i);
			if (arr[i] < arr[n]) {
				max = Math.max(max, res + 1);
			}
		}
		
		return max;
	}
	
	private static int lis(int[] arr) {
		int n = arr.length;
		int length[] = new int[n];
		
		length[0] = 1;
		for (int i = 1; i < n; ++i) {
			length[i] = 1;
			for (int j = 0; j < i; ++j) {
				if (arr[j] < arr[i]) {
					length[i] = Math.max(length[i], length[j] + 1);
				}
			}
		}
		return length[n - 1];
	}
	
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
		int n = arr.length;
		int max = lis(arr, n - 1);
		System.out.println(max);
		
		int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		n = A.length;
		max = lis(A, n - 1);
		System.out.println(max);
		
		max = lis(arr);
		System.out.println(max);
		max = lis(A);
		System.out.println(max);
	}
}
