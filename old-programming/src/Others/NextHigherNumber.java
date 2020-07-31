/*
 * Problem statement: 
 * Given a number n, find the smallest number that has same set of digits as n and is greater than n. 
 * If x is the greatest possible number with its set of digits, then print “not possible”.
 * 
 * Link: https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 */

package Others;

import java.util.Arrays;

public class NextHigherNumber {
	private static int nextGreaterNumber(int number) {
		char []array = String.valueOf(number).toCharArray();
		
		// Find the first descending number from right
		int i = array.length - 1;
		while (i >= 1 && array[i - 1] >= array[i]) {
			i--;
		}
		
		// If no number then number already greatest
		if (i == 0) {
			return Integer.MIN_VALUE;
		}
		
		// Find least greater number in right side
		int swap_left = i - 1;
		int least_bigger = i;
		for (int j = i + 1; j < array.length; ++j) {
			if (array[j] > array[swap_left] && array[j] < array[least_bigger]) {
				least_bigger = j;
			}
		}
		
		// Swap above 2 number
		char temp = array[least_bigger];
		array[least_bigger] = array[swap_left];
		array[swap_left] = temp;

		// Sort to the right
		Arrays.sort(array, swap_left + 1, array.length);
		
		return Integer.parseInt(new String(array)) ;
	}
	
	public static void main(String[] args) {
		int number = 4239865;
		int nextBigger = nextGreaterNumber(number);
		System.out.println("Number: " + number + ", next bigger: " + nextBigger);
		
		number = 423865;
		nextBigger = nextGreaterNumber(number);
		System.out.println("Number: " + number + ", next bigger: " + nextBigger);
	}
}
