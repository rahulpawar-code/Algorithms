/*
 * https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 */

package arrays;

public class MaximumIndexDifference {
	private static int maxIndexDifference(int arr[]) {
		if (arr == null || arr.length <= 1) {
			return -1;
		}
		int maxDiff = -1;
		
		for (int i = 0; i < arr.length; ++i) {
			for (int j = arr.length - 1; j > i; --j) {
				if (arr[i] < arr[j] && maxDiff < (j - i)) {
					maxDiff = j - i;
					break;
				}
			}
		}
		
		return maxDiff;
	}
	
	private static int maxIndexDifference2(int arr[]) {
		if (arr == null || arr.length <= 1) {
			return -1;
		}
		
		int n = arr.length;
		int LMin[] = new int[n];
		
		LMin[0] = arr[0];
		for (int i = 1; i < n; ++i) {
			LMin[i] = Math.min(LMin[i - 1], arr[i]);
		}
		
		int RMax[] = new int[n];
		RMax[n - 1] = arr[n - 1];
		for (int j = n - 2; j >= 0; --j) {
			RMax[j] = Math.max(RMax[j + 1], arr[j]);
		}
		
		int i = 0;
		int j = 0;
		int maxDiff = -1;
		while(j < n && i < n) {
			if (LMin[i] < RMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j++;
			} else {
				i++;
			}
		}
		
		return maxDiff;
	}
	
	public static void main(String[] args) {
		int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}; 
		int maxDiff = maxIndexDifference(arr);
		System.out.println(maxDiff);
		maxDiff = maxIndexDifference2(arr);
		System.out.println(maxDiff);
		
		int arr2[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		maxDiff = maxIndexDifference(arr2);
		System.out.println(maxDiff);
		maxDiff = maxIndexDifference2(arr2);
		System.out.println(maxDiff);
	}
}
