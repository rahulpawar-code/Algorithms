/*
 * Link: https://www.careercup.com/question?id=5652049329389568
 * 
 * Problem Statement:
 * Given a series of equations e.g. [A = B, B = D, C = D, F = G, E = H, H = C] 
 * and then another series [A != C, D != H, ..., F != A ] 
 * Check whether the equations combined is valid.
 * 
 * Solution:
 * merge set with path compression
 */

package Others;

public class EqualityInequalityEquations {
	// Find the representative element and compress path
	private static int findSet(int set[], int i) {
		int source_i = i;
		while (source_i != set[source_i]) {
			source_i = set[source_i];
		}
		
		int tmp;
		while (i != set[i]) {
			tmp = set[i];
			set[i] = source_i;
			i = tmp;
		}
		
		return source_i;
	}
	
	// Merge 2 sets
	private static void mergeSets(int set[], int a, int b) {
		int sourceA = findSet(set, a);
		int sourceB = findSet(set, b);
		set[sourceB] = sourceA;
	}
	
	private static boolean validSequence(char[][] equals, char[][] unequals) {
		int set[] = new int[26];
		for (int i = 0; i < 26; ++i) {
			set[i] = i;
		}
		
		for(char[] pair: equals) {
			mergeSets(set, pair[0] - 'A', pair[1] - 'A');
		}
		
		for (int i = 0; i < 26; i++) {
			findSet(set, i);
		}
		
		for (char[] pair : unequals) {
			if (set[pair[0] - 'A'] == set[pair[1] - 'A']) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		char[][] equal = {{'A','B'}, {'B','D'},{'C','D'},{'F','G'},{'E','H'},{'H','C'}};
		char[][] unequal = {{'A','C'}, {'D','H'}, {'F','A'}};
		
		if (validSequence(equal, unequal))
			System.out.println("Valid");
		else 
			System.out.println("Invalid");
		
	}
}
