package DynamicProgramming;
import java.util.*;


public class BinaryKnapsack {
	private static int knapsackTopDown(int W, int wt[], int v[], int n, HashMap<String, Integer> map) {
		if (n == 0 || W == 0)
			return 0;
		
		if (wt[n] > W) {
			return knapsackTopDown(W, wt, v, n - 1, map);
		}
		
		String key = n + "|" + W;
		if (!map.containsKey(key)) {
			int include = v[n] + knapsackTopDown(W - wt[n], wt, v, n - 1, map);
			int exclude = knapsackTopDown(W, wt, v, n - 1, map);
			map.put(key, Math.max(include, exclude));
		}
		
		return map.get(key);
	}
	
	private static int knapsackTopDown(int W, int wt[], int v[], int n) {
		HashMap<String, Integer> map = new HashMap<>();
		return knapsackTopDown(W, wt, v, n, map);
	}
	
	private static int knapsackRec(int W, int[] wt, int[] v, int n) {
		if (n < 0 || W == 0)
			return 0;
		
		if (wt[n] > W) {
			return knapsackRec(W, wt, v, n - 1);
		}
		
		return Math.max(v[n] + knapsackRec(W - wt[n], wt, v, n - 1), knapsackRec(W, wt, v, n - 1) );		
	}

	private static int knapsackIter(int W, int wt[], int v[]) {
		int n = wt.length;
		int table[][] = new int[W + 1][n + 1];
		
		for (int w = 0; w <= W; ++w) {
			for (int i = 0; i <= n; ++i) {
				if (w == 0 || i == 0) {
					table[w][i] = 0;
				} else if (wt[i - 1] > w) {
					table[w][i] = table[w][i - 1];
				} else {
					table[w][i] = Math.max(v[i - 1] + table[w - wt[i - 1]][i - 1], table[w][i - 1]);
				}
			}
		}
		
		
		return table[W][n];
	}
	
	public static void main(String[] args) {
		int wt[] = new int[]{10, 20, 30}; 
	    int W = 50; 
	    int val[] = new int[]{60, 100, 120};
	    int v = knapsackRec(W, wt, val, val.length - 1);
	    System.out.println("Method 1: " + v);
	    v = knapsackTopDown(W, wt, val, val.length - 1);
	    System.out.println("Method 2: " + v);
	    v = knapsackIter(W, wt, val);
	    System.out.println("Method 3: " + v);
	    
	    
		int[] val2 = { 20, 5, 10, 40, 15, 25 };
		int[] wt2 = { 1, 2, 3, 8, 7, 4 };
		int W2 = 10;
		int n2 = val2.length;
		v = knapsackRec(W2, wt2, val2, n2 - 1);
		System.out.println("Method 1: " + v);
	}

}
