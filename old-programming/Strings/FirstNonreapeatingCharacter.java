/*
 * https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
 */

package Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstNonreapeatingCharacter {
	private static final int NUM_CHARS = 256;
	
	private static char firstNonRepeating(String str) {
		if (str == null || str.length() <= 1) {
			return '\0';
		}
		
		int count[] = new int[NUM_CHARS];
		
		for (int i = 0 ; i < str.length(); ++i) {
			count[str.charAt(i)]++;
		}
		
		for (int i = 0 ; i < str.length(); ++i) {
			if (count[str.charAt(i)] == 1) {
				return str.charAt(i);
			}
		}
		
		return '\0';
	}
	
	private static char firstNonRepeating2(String str) {
		if (str == null || str.length() <= 1) {
			return '\0';
		}
		
		char c = '\0';
		
		ArrayList<Character> inDLL = new ArrayList<Character>();
		boolean repeated[] = new boolean[NUM_CHARS];
		
		for(int i = 0; i < str.length(); ++i) {
			char current = str.charAt(i);
			
			if (!repeated[current]) {
				if (!inDLL.contains(current)) {
					inDLL.add(current);
				} else {
					repeated[current] = true;
					inDLL.remove((Character)current);
				}
			} 
		}
		
		if (inDLL.size() != 0) {
			c = inDLL.get(0);
		}
		
		return c;
	}
	
	private static char firstKthNonRepeating(String str, int k) {
		if (str == null || str.length() <= 1 || k <= 0) {
			return '\0';
		}
		
		char c = '\0';
		
		ArrayList<Character> inDLL = new ArrayList<Character>();
		boolean repeated[] = new boolean[NUM_CHARS];
		
		for(int i = 0; i < str.length(); ++i) {
			char current = str.charAt(i);
			
			if (!repeated[current]) {
				if (!inDLL.contains(current)) {
					inDLL.add(current);
				} else {
					repeated[current] = true;
					inDLL.remove((Character)current);
				}
			} 
		}
		
		if (inDLL.size() >= k) {
			c = inDLL.get(k - 1);
		}
		
		return c;
	}
	
	private static char firstKthNonRepeating2(String str, int k) {
		if (str == null || str.length() <= 1 || k <= 0) {
			return '\0';
		}
		
		char c = '\0';
		
		int index[] = new int[NUM_CHARS];
		int count[] = new int[NUM_CHARS];
		int n = str.length();
		
		for (int i = 0; i < index.length; ++i) {
			index[i] = n;
		}
		
		for (int i = 0; i < str.length(); ++i) {
			char current = str.charAt(i);
			count[current]++;
			
			if (count[current] == 1) {
				index[current] = i;
			}
			
			if (count[current] == 2) {
				index[current] = n;
			}
		}
		
		Arrays.sort(index);
		
		if (k - 1 < n && index[k - 1] < n) {
			c = str.charAt(index[k - 1]);
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		String str = "geeksforgeek";
		char c = ' ';
		int k = 3;
		
		c = firstNonRepeating(str);
		System.out.println(c);
		
		c = firstNonRepeating2(str);
		System.out.println(c);
		
		c = firstKthNonRepeating(str, k);
		System.out.println(c);
		
		c = firstKthNonRepeating2(str, k);
		System.out.println(c);
		
	}

}
