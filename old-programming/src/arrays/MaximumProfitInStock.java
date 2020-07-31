package arrays;

import java.util.ArrayList;

public class MaximumProfitInStock {
	static class Interval {
		int buy;
		int sell;
		int profit;
	}

	private static int getMaxTwoProfits(int[] prices) {
		if (prices == null || prices.length <= 3) {
			return 0;
		}
		
		int n = prices.length;
		int[] profit = new int[n];
		int maxPrice = prices[n - 1];
		
		// get max profit from this day till end
		for (int i = n - 2; i >= 0; --i) {
			profit[i] = Math.max(profit[i + 1], maxPrice - prices[i]);
			maxPrice = Math.max(maxPrice, prices[i]);
		}
		
		int minPrice = prices[0];
		// get min price from start and update profit to store maximum profit
		for (int i = 1; i <= n - 1; ++i) {
			profit[i] = Math.max(profit[i - 1], prices[i] - minPrice + profit[i]);
			minPrice = Math.min(minPrice, prices[i]);
		}
		
		return profit[n - 1];
	}
	
	private static int getOneMaxProfit(int prices[]) {
		if (prices == null || prices.length <= 1) {
			return -1;
		}
		
		int minimaIndex = 0;
		int maxProfit = 0;
		
		for (int i = 1; i < prices.length; ++i) {
			int profit = prices[i] - prices[minimaIndex];
			maxProfit = profit > maxProfit ? profit : maxProfit;
			minimaIndex = prices[i] < prices[minimaIndex] ? i : minimaIndex;
		}
		return maxProfit;
	}
	 
	private static void maxAllProfit1(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return;
		}
		
		int n = prices.length;
		int i = 0;
		int count = 0;
		
		ArrayList<Interval> solutions = new ArrayList<>(); 
		while (i < n - 1) {
			while ((i < n - 1) && (prices[i] >= prices[i + 1] )) {
				i++;
			}
			if (i == n - 1) {
				break;
			}
			
			Interval interval = new Interval();
			interval.buy = i++;
			
			while (i < n && prices[i] >= prices[i - 1]) {
				i++;
			}
			interval.sell = i - 1;
			interval.profit = prices[interval.sell] - prices[interval.buy];
			count++;
			solutions.add(interval);	
		}
		
		for (Interval interval: solutions) {
			System.out.println(interval.buy + ":" + interval.sell + ", " + interval.profit);
		}
	}

	public static int getAllMaxProfit2(int prices[]) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		
		int profit = 0;
		int minIndex = 0;
		
		for (int i = 1; i < prices.length; ++i) {
			if (prices[i - 1] > prices[i]) {
				minIndex = i;
			}
			
			if ((prices[i - 1] < prices[i]) && (i + 1 == prices.length || prices[i] > prices[i + 1])) {
				profit += prices[i] - prices[minIndex];
			}
		}
		
		
		return profit;
	}
	
	private static int maxKProfit(int prices[], int k) {
		if (prices == null || prices.length <= 1 || k <= 0 || prices.length < k / 2) {
			return 0;
		}
		
		int n = prices.length;
		int profit[][] = new int[k + 1][n];
		
		for (int i = 0; i <= k; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == 0 || j == 0) {
					profit[i][j] = 0;
				} else {
					int maxSoFar = 0;
					for (int l = 0; l < j; ++l) {
						int current = prices[j] - prices[l] + profit[i - 1][l];
						maxSoFar = Math.max(maxSoFar, current);
					}
					profit[i][j] = Math.max(maxSoFar, profit[i][j - 1]); 
				}
			}
		}
		
		
		return profit[k][n-1];
	}
	
	public static void main(String[] args) {
		System.out.println("------------ Case 1 ------------");
		
		int prices[] = { 100, 180, 260, 310, 40, 535, 695 };
		
		System.out.println("Maximum profit: " + getOneMaxProfit(prices));
		System.out.println("\nMax profit in 2 transactions: " + getMaxTwoProfits(prices));
		System.out.println("\nMax profit in all transactions: " + getAllMaxProfit2(prices));
		
		System.out.println("\nMaximum profit all intervals:");
		MaximumProfitInStock.maxAllProfit1(prices);
		
		System.out.println("\n------------ Case 2 ------------");
		int prices2[] = {2, 4, 7, 5, 4, 3, 5};
		System.out.println("Maximum profit: " + getOneMaxProfit(prices2));
		System.out.println("\nMax profit in 2 transactions: " + getMaxTwoProfits(prices2));
		System.out.println("\nMax profit in all transactions: " + getAllMaxProfit2(prices2));
		System.out.println("\nMaximum profit all intervals:");
		MaximumProfitInStock.maxAllProfit1(prices2);
		
		
		System.out.println("\n------------ Case 3 ------------");
		int prices3[] = {-2, -4, -7, -5, -4, -3, -5};
		System.out.println("Maximum profit new: " + getAllMaxProfit2(prices3));
		System.out.println("\nMax profit in 2 transactions: " + getMaxTwoProfits(prices3));
		System.out.println("\nMax profit in all transactions: " + getAllMaxProfit2(prices3));
		System.out.println("\nMaximum profit all intervals:");
		MaximumProfitInStock.maxAllProfit1(prices3);
		
		System.out.println("\n------------ Case 4 ------------");
		int prices4[] = {9,8,7,6,5,4,3,2,1,0};
		System.out.println("Maximum profit: " + getOneMaxProfit(prices4));
		System.out.println("\nMax profit in 2 transactions: " + getMaxTwoProfits(prices4));
		System.out.println("\nMax profit in all transactions: " + getAllMaxProfit2(prices4));
		System.out.println("\nMaximum profit all intervals:");
		MaximumProfitInStock.maxAllProfit1(prices4);
		
		System.out.println("\n------------ Case 5 ------------");
		int prices5[] = {1, 5, 2, 3, 7, 6, 4, 5};
		int k = 3;
		System.out.print("The maximum possible profit is: " + maxKProfit(prices5, k));
		
	}

}
