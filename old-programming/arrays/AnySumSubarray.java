/*
 * https://www.techiedelight.com/check-subarray-with-0-sum-exists-not/
 */

package arrays;

import java.util.HashSet;


public class AnySumSubarray {	
	public static boolean zeroSumSubarray(int[] array) {
		if (array == null || array.length == 0) {
			return false;
		}
		
		HashSet<Integer> set= new HashSet<>();
		int sum = 0;
		for (int a : array) {
			sum += a;
			if (set.contains(sum)) {
				return true;
			} 
			set.add(sum);
		}
		
		return false;
	}
	
	public static boolean anySumSubarray(int[] array, int desiredSum) {
		if (array == null || array.length == 0) {
			return false;
		}
		
		HashSet<Integer> set= new HashSet<>();
		int sum = 0;
		for (int a : array) {
			sum += a;
			if (set.contains(sum - desiredSum)) {
				return true;
			} 
			set.add(sum);
		}
		
		return false;
	}
	
	private static void printArray(int start, int end, int[] array) {
		for (int i = start; i <= end; ++i) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
	
	public static void printZeroSumSubarrays(int array[]) {
		if (array == null || array.length == 0) {
			 return;
		}
		
		for (int i = 0; i < array.length; i++) {
			int sum = 0;
			for (int j = i; j < array.length; j++) {
				sum += array[j];
				if (sum == 0) {
					printArray(i, j, array);
				}
			}
		}
	}
	
	public static void printAnySumSubarrays(int array[], int desiredSum) {
		if (array == null || array.length == 0) {
			 return;
		}
		
		for (int i = 0; i < array.length; i++) {
			int sum = 0;
			for (int j = i; j < array.length; j++) {
				sum += array[j];
				if (sum == desiredSum) {
					printArray(i, j, array);
				}
			}
		}
	}
	
	private static void testZeroSum(int array[]) {
		boolean result = zeroSumSubarray(array);
		if (result) {
			System.out.println("Zero sum subarray exists");
		} else {
			System.out.println("Zero sum subarray do not exist");
		}
	}
	
	private static void testAnySum(int array[], int sum) {
		boolean result = anySumSubarray(array, sum);
		if (result) {
			System.out.println(sum + " sum subarray exists");
		} else {
			System.out.println(sum + " sum subarray do not exist");
		}
	}
	
	private static void runTests(int array[], int desiredSum) {
		if (desiredSum == 0) {
			testZeroSum(array);
			printZeroSumSubarrays(array);
		} else {
			testAnySum(array, desiredSum);
			printAnySumSubarrays(array, desiredSum);
		}
		
		System.out.println("------------");
	}
	
	public static void main(String[] args) {
		int array[] = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
		runTests(array, 0);
		runTests(array, 8);
		runTests(array, -3);
		runTests(array, -7);
		runTests(array, 100);
	}
}
