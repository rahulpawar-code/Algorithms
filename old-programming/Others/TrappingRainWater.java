/*
 * Problem Statement:
 * Given n non-negative integers representing an elevation map where
 * the width of each bar is 1, compute how much water it is able to
 * trap after raining.
 * 
 * Problem Link:
 * https://www.geeksforgeeks.org/trapping-rain-water/
 */

package Others;

public class TrappingRainWater {
	private static int findWater(int array[]) {
		if (array == null) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		int rainwater = 0;
		int n = array.length;
		int leftMax[] = new int[n];
		int rightMax[] = new int[n];
		
		
		leftMax[0] = array[0];
		for (int i = 1 ; i < n; ++i) {
			leftMax[i] = Math.max(array[i], leftMax[i-1]);
		}
		
		rightMax[n-1] = array[n-1];
		for (int i = n - 2; i >= 0; --i) {
			rightMax[i] = Math.max(array[i], rightMax[i + 1]);
		}
		
		for (int i = 0; i < n; ++i) {
			rainwater += Math.min(leftMax[i], rightMax[i]) - array[i];
		}
		
		return rainwater;
	}
	
	private static int findWater2(int array[]) {
		if (array == null) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		int rainwater = 0;
		int n = array.length;
		
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;
		
		int leftIndex = 0;
		int rightIndex = n - 1;
		
		while (leftIndex < rightIndex) {
			if (array[leftIndex] < array[rightIndex]) {
				if (array[leftIndex] > leftMax) {
					leftMax = array[leftIndex];
				} else {
					rainwater += leftMax - array[leftIndex];
				}
				leftIndex++;
			} else {
				if (array[rightIndex] > rightMax) {
					rightMax = array[rightIndex];
				} else {
					rainwater += rightMax - array[rightIndex];
				}
				rightIndex--;
			}
		}
		
		return rainwater;
	}
	
	public static void main(String args[]) {
		int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 0, 2};
		int rainwater = findWater(arr); 
		
		System.out.println("Maximum water accumlated (nethod 1): " + rainwater); 
		
		rainwater = findWater2(arr);
		System.out.println("Maximum water accumlated (nethod 2): " + rainwater); 
		
	}
}
