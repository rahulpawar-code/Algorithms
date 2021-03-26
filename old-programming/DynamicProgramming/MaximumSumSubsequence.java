package DynamicProgramming;

import java.util.ArrayList;

public class MaximumSumSubsequence {
	private static int maximumSumSequence(int arr[]) {
		int n = arr.length;
		int sum[] = new int[n];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for (int i = 0; i < n; ++i) {
			list.add(i, new ArrayList<>());
		}
		
		list.get(0).add(arr[0]);
		sum[0] = arr[0];
		
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (sum[i] < sum[j] && arr[j] < arr[i]) {
					list.set(i, new ArrayList<>(list.get(j)));
					sum[i] = sum[j];
				}
			}
			sum[i] += arr[i];
			list.get(i).add(arr[i]);
		}
		
		int j = 0;
		for (int i = 1; i < n; ++i) {
			if (sum[j] < sum[i]) {
				j = i;
			}
		}
		
		System.out.println(list.get(j));
		
		return sum[j];
	}
	
	private static int maximumSumSequence(int arr[], int i, int previous, int sum) {
		if (i == arr.length) {
			return sum;
		}
		int excluding = maximumSumSequence(arr, i + 1, previous, sum);
		int including = sum;
		if (previous < arr[i]) {
			including = maximumSumSequence(arr, i + 1, arr[i], sum + arr[i]);
		}
		
		return Math.max(excluding, including);
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 101, 2, 3, 100, 4, 5};
		int sum = maximumSumSequence(arr);
		System.out.println(sum);
		sum = maximumSumSequence(arr, 0, Integer.MIN_VALUE, 0);
		System.out.println(sum);
	}
}
