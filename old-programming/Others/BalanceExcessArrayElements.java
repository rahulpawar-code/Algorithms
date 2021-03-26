/*
 * Problem Statement:
 * Given an array, coin of size n, coin[i] denotes the no. of coins on the position i.
 * Can move any number of coins from the position i to (i+1) or (i-1). What is the
 * minimum no. of moves required to redistribute the coins, so that each position i has
 * at least 1 coin ? Note: Summation of total coins on the array is exactly n.
 * 
 * Link: https://www.careercup.com/question?id=5530674031755264
 */
		

package Others;

import java.util.Stack;

public class BalanceExcessArrayElements {
	private static void printArray(int arr[]) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println("");
	}
	
	private static int countMoves(int coins[]) {
		if (coins == null) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		if (coins.length == 0 || coins.length == 1) {
			return 0;
		}
		
		Stack<Integer> missingStack = new Stack<>();
		Stack<Integer> excessStack = new Stack<>();
		int cumulativeLeftMissing[] = new int[coins.length + 1];
		int cumulativeRightMissing[] = new int[coins.length + 1];
		
		cumulativeRightMissing[coins.length] = 0;
		for (int i = coins.length - 1; i >= 0; --i) {
			cumulativeRightMissing[i] += cumulativeRightMissing[i + 1];
		}
		
		cumulativeLeftMissing[0] = 0;
		for (int i = 1; i <= coins.length; ++i) {
			cumulativeLeftMissing[i] += cumulativeLeftMissing[i - 1];
		}		
		
		for (int i = coins.length - 1; i >= 0; --i) {
			if (coins[i] > 1) {
				excessStack.push(i);
			} else if (coins[i] == 0) {
				missingStack.push(i);
			} else if (coins[i] < 0){
				throw new IllegalArgumentException("Illegal element in input array");
			}
		}
		
		printArray(coins);
		int moves = 0;
		while (!excessStack.isEmpty()) {
			int missingIndex = missingStack.peek();
			int excessIndex = excessStack.peek();
			int required = 0;
			if (missingIndex < excessIndex) {
				required = Math.abs(cumulativeLeftMissing[excessIndex] - coins[excessIndex]);
				coins[excessIndex - 1] += required;
				coins[excessIndex] -= required;
				if (coins[excessIndex] == 1) {
					excessStack.pop();
				}
				if (coins[excessIndex - 1] > 1) {
					excessStack.push(excessIndex - 1);
				}
			} else {
				required = coins[excessIndex] - 1;
				coins[excessIndex + 1] += required;
				coins[excessIndex] = 1;
				excessStack.pop();
				if (coins[excessIndex + 1] > 1) {
					excessStack.push(excessIndex + 1);
				}
			}
			moves++;
		}
		
		return moves;
	}

	public static void main(String[] args) {
		int coins[] = {0, 3, 1, 0, 3, 0, 0};
		int moves = countMoves(coins);
		System.out.println("Test case 1: moves required: " + moves + "\n");
		
		int coins2[] = {0, 2};
		moves = countMoves(coins2);
		System.out.println("Test case 2: moves required: " + moves + "\n");
	}
}