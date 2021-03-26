/*
 * Problem Statement:
 * Given max. travel distance and forward and backward route list, return pair
 * of ids of forward and backward routes that optimally utilized the max travel
 * distance.:
 * eg: max travel distance is : 11000
 * forward route list :    [1,3000],[2,5000],[3,4000],[4,10000]
 * backward route list : [1,2000],[2,3000],[3,4000] 
 * Result : [2,3]  ...2 is from forward and 3 is from backward...total distance
 *  is 9000...
 * 
 * Link: https://www.careercup.com/question?id=5750442676453376
 */

package Others;

import java.util.Arrays;

// Represents (ID, distance pair)
class CustomPair implements Comparable<CustomPair> {
	int id;
	int distance;
	
	public CustomPair(int i, int d) {
		id = i;
		distance = d;
	}

	// Sorting method to sort pairs on distance parameter
	@Override
	public int compareTo(CustomPair o) {
		return this.distance - o.distance;
	}
}

public class ElementPairsInTwoArrays {
	private static void findClosestPair(int closestPair[], CustomPair[] forward, CustomPair[] backward, int value) {
		if (closestPair == null || forward == null || backward == null || closestPair.length < 2) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		Arrays.sort(forward);
		Arrays.sort(backward);
		
		int minDifference = Integer.MAX_VALUE;
		int i = 0;
		int j = backward.length - 1;
		
		while (i < forward.length && j >= 0) {
			CustomPair firstPair = forward[i];
			CustomPair secondPair = backward[j];
			if (value - (firstPair.distance + secondPair.distance) < minDifference) {
				minDifference = value - (firstPair.distance + secondPair.distance);
				closestPair[0] = i;
				closestPair[1] = j;
			}
			
			if (firstPair.distance + secondPair.distance < value) {
				i++;
			} else if (firstPair.distance + secondPair.distance < value) {
				j--;
			} else {
				break;
			}
		}		
	}
	
	public static void main(String args[]) {
		CustomPair forward[] = {new CustomPair(1, 3000), new CustomPair(2, 5000), 
				new CustomPair(3, 4000), new CustomPair(1, 10000)};
		CustomPair backward[] = {new CustomPair(1, 2000), new CustomPair(2, 3000), 
				new CustomPair(3, 4000)};
		
		int[] closestPair = {-1, -1};
		int value = 11000;
		
		findClosestPair(closestPair, forward, backward, value);
		
		if (closestPair[0] != -1 && closestPair[1] != -1) {
			System.out.println("Closest pair ids: " + closestPair[0] + " , " + closestPair[1]);
		} else {
			System.out.println("Can't find closest pair");
		}
		
	}

}
