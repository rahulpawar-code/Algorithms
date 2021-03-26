// https://www.geeksforgeeks.org/the-celebrity-problem/

package Others;

import java.util.Stack;

public class CelebrityProblem {
	private static int relationship1[][] = {{0, 1, 0, 0, 0, 1},
										   {1, 0, 0, 1, 1, 1},
										   {0, 0, 0, 1, 0, 1},
										   {1, 0, 0, 0, 0, 1},
										   {0, 0, 1, 0, 0, 1},
										   {0, 0, 0, 0, 0, 0}};
	
	private static int relationship2[][] = {{0, 1, 0, 0, 0, 1},
			   {1, 0, 0, 1, 1, 1},
			   {0, 0, 0, 1, 0, 1},
			   {1, 0, 0, 0, 0, 1},
			   {0, 0, 1, 0, 0, 1},
			   {0, 0, 1, 0, 0, 0}};
	
	private static boolean knows(int personA, int personB, int relationship[][]) {
		return (relationship[personA][personB] == 1);
	}	
	
	// Method 1 (selection), using in degree and out degree of vertices
	private static boolean isCelebrityPresent1(int n, int relationship[][]) {
		if (relationship == null || n <= 0) {
			return false;
		}
		
		int[] inDegree = new int[n];
		int[] outDegree = new int[n];
		boolean result = false;
		
		
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (knows(i, j, relationship)) {
					outDegree[i]++;
					inDegree[j]++;
				}
				if (knows(j, i, relationship)) {
					outDegree[j]++;
					inDegree[i]++;
				}
			}
		}
		
		for (int i = 0; i < n; ++i) {
			if ((inDegree[i] == n -1) && (outDegree[i] == 0)) {
				result = true;
			}
		}
		
		return result;
	}
	
	// Method 2 (elimination), 
	private static boolean isCelebrityPresent2(int n, int relationship[][]) {
		if (relationship == null || n <= 0) {
			return false;
		}
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; ++i) {
			stack.push(i);
		}
		
		while (stack.size() > 1) {
			int personA = stack.pop();
			int personB = stack.pop();
			
			if (knows(personA, personB, relationship)) {
				stack.push(personB);
			} else {
				stack.push(personA);
			}
		}
		
		int remainingPerson = stack.pop();
		for (int i = 0; i < n; ++i) {
			if (i != remainingPerson &&
				!knows(i, remainingPerson, relationship) &&
				knows(remainingPerson, i, relationship)) {
				return false;
			}
		}
		
		return true;
	}
	
	// Method 3 (elimination), no data structure
	private static boolean isCelebrityPresent3(int n, int relationship[][]) {
		if (relationship == null || n <= 0) {
			return false;
		}
		
		int personA = 0;
		int personB = n - 1;
		
		while (personA < personB) {
			if (knows(personA, personB, relationship)) {
				personA++;
			} else {
				personB--;
			}
		}
		
		boolean result = true;
		for (int i = 0; i < n; ++i) {
			if (i != personA && (!knows(i, personA, relationship) || knows(personA, i, relationship))) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	
	private static void test(int i, int num, int relationship[][], boolean expected) {
		String resultString = "Test case " + i + ": ";
		
		if (isCelebrityPresent1(num, relationship) == expected) {
			resultString += "method1 passed, ";
		} else {
			resultString += "method1 failed, ";
		}
		
		if (isCelebrityPresent2(num, relationship) == expected) {
			resultString += "method2 passed, ";
		} else {
			resultString += "method2 failed, ";
		}
		
		if (isCelebrityPresent3(num, relationship) == expected) {
			resultString += "method3 passed.";
		} else {
			resultString += "method3 failed.";
		}
		
		System.out.println(resultString);
	}
	
	public static void main(String[] args) {
		test(1, 6, relationship1, true); // Celebrity present
		test(2, 6, relationship2, false); // Celebrity absent
		test(3, 10, null, false); // -ve test
		test(4, 0, null, false); // -ve test
	}
}
