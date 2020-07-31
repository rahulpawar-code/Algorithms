package DynamicProgramming;

public class CoinChange2 {
	private static int count(int[] S, int sum) {
		if (sum == 0) {
			return 1;
		}
		if (sum < 0) {
			return 0;
		}
		
		int res = 0;
		for (int i = 0; i < S.length; ++i) {
			res += count(S, sum - S[i]);
		}
		return res;
	}
	
	
	private static int count(int[] S, int sum, int n) {
		if (sum == 0) {
			return 1;
		}
		
		if (sum < 0) {
			return 0;
		}
		
		if (n < 0 && sum >= 1) {
			return 0;
		}
		
		return count(S, sum, n - 1) + count(S, sum - S[n], n);
	}
	
	
	public static void main(String[] args) {
		int S[] = {1, 2, 3};
		int sum = 4;
		int n = count(S, sum);
		System.out.println(n);
		n = count(S, sum, S.length - 1);
		System.out.println(n);
	}
}
