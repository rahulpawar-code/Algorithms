package DynamicProgramming;

public class MinimumJunps {
	private static int minJumps(int arr[], int l, int h) {
		if (l == h) {
			return 0;
		}
		if (arr[l] == 0) {
			return Integer.MAX_VALUE;
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = l + 1; i <= h && i <= l + arr[l]; ++i) {
			int jump = minJumps(arr, i, h);
			if (jump != Integer.MAX_VALUE) {
				min = Math.min(min, jump + 1);
			}
		}
		return min;
	}

	private static int minJumps(int arr[]) {
		if (arr == null || arr[0] == 0) {
			return Integer.MAX_VALUE;
		}
		
		int n = arr.length;
		int jumps[] = new int[n];
		jumps[0] = 0;
		
		for (int i = 1; i < n; ++i) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; ++j) {
				if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		
		for (int i = 0; i < n; ++i) {
			System.out.print(jumps[i] + " ");
		}
		
		return jumps[n - 1];
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		int n = arr.length;
		int l = 0;
		int h = n - 1;
		int jumps = minJumps(arr, l, h);
		System.out.println(jumps);
		jumps = minJumps(arr);
		System.out.println(jumps);
	}
}
