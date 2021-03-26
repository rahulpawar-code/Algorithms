package arrays;

/*
 * https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 */


public class EquilibriumPoint {
	private static int getArraySum(int arr[]) {
		if (arr == null) {
			return 0;
		}
		
		int sum = 0;
		for (int a : arr) {
			sum += a;
		}
		
		return sum;
	}
	
	private static int findEquilibriumPoint1(int arr[]) {
		if (arr == null || arr.length <= 1) {
			throw new IllegalArgumentException("Invalid array");
		}
		
		int leftSum = 0;
		for (int i = 0; i < arr.length - 1; ++i) {
			leftSum += arr[i];
			int rightSum = 0;
			for (int j = i + 1; j < arr.length; ++j) {
				rightSum += arr[j];
			}
			if (leftSum == rightSum) {
				return i + 1;
			}
		}
		
		return -1;
	}
	
	private static int findEquilibriumPoint2(int arr[]) {
		if (arr == null || arr.length <= 1) {
			throw new IllegalArgumentException("Invalid array");
		}
		int rightSum = getArraySum(arr);
		int leftSum = 0;
		
		for (int i = 0; i < arr.length - 1; ++i) {
			leftSum += arr[i];
			rightSum -= arr[i];
			
			if (leftSum == rightSum) {
				return i + 1;
			}
		}
		
		return -1;
	}
	
	private static int findEquilibriumPoint3(int arr[])  {
		if (arr == null || arr.length <= 0) {
			throw new IllegalArgumentException("Invalid array");
		}
		
		if (arr.length == 1) {
		    return 1;
		}
		
		if (arr.length == 2) {
		    return -1;
		}
		
		int rightSum = getArraySum(arr) - arr[0];
		int leftSum = 0;
		
		for (int i = 1; i < arr.length - 1; ++i) {
			leftSum += arr[i - 1];
			rightSum -= arr[i];
			
			System.out.println(leftSum + " : " + rightSum);
			
			if (leftSum == rightSum) {
				return i + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = { -7, 1, 5, 2, -4, 3, 0};
		int point1 = findEquilibriumPoint1(arr);
		System.out.println("Method 1 : " + point1);
		
		int point2 = findEquilibriumPoint2(arr);
		System.out.println("Method 2 : " + point2);
		
		int arr2[] = {1, 3, 5, 2, 2};
		int point3 = findEquilibriumPoint3(arr2);
		System.out.println("Method 3 : " + point3);
		
	}
}
