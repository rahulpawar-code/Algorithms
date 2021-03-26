package DynamicProgramming;

public class CoinChange {
	private static int findMinCoins(int S[], int N) {
		if (N == 0) {
			return 0;
		}
		
		if (N < 0) {
			return Integer.MAX_VALUE;
		}
		
		int coins = Integer.MAX_VALUE;
		for (int i = 0; i < S.length; ++i) {
			int res = findMinCoins(S, N - S[i]);
			if (res != Integer.MAX_VALUE) {
				coins = Math.min(coins, res + 1);
			}
		}
		return coins;
	}
	
	private static int findMinCoinsIter(int S[], int N) {
		int T[] = new int[N + 1];
		
		for (int t = 1; t <= N; ++t) {
			T[t] = Integer.MAX_VALUE;
			int res = Integer.MAX_VALUE;
			
			for (int s = 0; s < S.length; ++s) {
				if (t - S[s] >= 0) {
					res = T[t - S[s]];
				}
				if (res != Integer.MAX_VALUE) {
					T[t] = Math.min(T[t], res + 1);
				}
			}
		}
		return T[N];
	}
	
	public static void main(String[] args) {
		int S[] = {1, 3, 5, 7};
		int N = 18;
		int n = findMinCoins(S, N);
		System.out.println(n);
		n = findMinCoinsIter(S, N);
		System.out.println(n);

	}

}
