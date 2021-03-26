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

public class BalanceExcessArrayElements2 {
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
		while (!missingStack.isEmpty()) {
			int missingIndex = missingStack.peek();
			int excessIndex = excessStack.peek();
			
			moves = moves + Math.abs(missingIndex - excessIndex);
			missingStack.pop();
			coins[excessIndex]--;
			coins[missingIndex]++;
			printArray(coins);
			
			if (coins[excessIndex] == 1) {
				excessStack.pop();
			}
		}
		
		return moves;
	}

	public static void main(String[] args) {
		int coins[] = {0, 3, 1, 0, 3, 0, 0};
		int moves = countMoves(coins);
		System.out.println("Test case 1: moves required: " + moves);
		
		int coins2[] = {0, 2};
		moves = countMoves(coins2);
		System.out.println("Test case 2: moves required: " + moves);
	}
}