/*
 *  Problem Statement : 4-Sum problem. Find pairs satisfying relation x + y + z = w
 *  
 *  Problem Link: https://www.careercup.com/question?id=6564870363807744
 */

package Others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Pair {
	int index1;
	int index2;
	
	public Pair(int i1, int i2) {
		index1 = i1;
		index2 = i2;
	}
}

public class FourSum {
	private static int countFourSum(int numbers[]) {
		if (numbers == null) {
			throw new IllegalArgumentException("Illegal argument");
		}
			
		if (numbers.length < 4) {
			return 0;
		}
		
		// Prepare a map for LHS side sum i.e. x + y as key and y index as value
		Map<Integer, List<Integer>> lhs = new HashMap<>();
		for (int i = 0; i < numbers.length - 1; ++i) {
			for (int j = i + 1; j < numbers.length; ++j) {
				// x + y
				int sum = numbers[i] + numbers[j]; 
				if (!lhs.containsKey(sum)) {
					List<Integer> list = new LinkedList<>();
					list.add(j);
					lhs.put(sum, list);
				} else {
					lhs.get(sum).add(j);
				}
			}
		}
		
		// Dual loop for iteration for z & w items. Calculate w - z and check if exists in map
		// If exists then check index of y from map and loop index for z item. 
		int count = 0;
		for (int i = 2; i < numbers.length - 1; ++i) {
			for (int j = i + 1; j < numbers.length; ++j) {
				int sum = numbers[j] - numbers[i];
				if (lhs.containsKey(sum)) {
					for (int index : lhs.get(sum)) {
						if (index < i) {
							count++;
						}
					}
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int numbers[] = {1,2,3,4,5,6,7,8,9,10};
		int countPairs = countFourSum(numbers);
		System.out.println("Number of pairs: " + countPairs);
		
	}
}