/*
 * Problem link: https://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
 */
package Strings;

import java.util.HashSet;
import java.util.Set;

public class PalindromeSubstrings {
	private static Set<String> getPalindromeSubstrings(String string) {
		if (string == null || string.isEmpty()) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < string.length(); ++i) {
			for (int j = i + 1; j <= string.length(); ++j) {
				if (j - i == 1) {
					set.add(new String(string.substring(i, j)));
				} else {
					String sub = string.substring(i, j);
					StringBuilder sb = new StringBuilder(sub);
					sb.reverse();
					if (sb.toString().compareTo(sub) == 0) {
						set.add(new String(string.substring(i, j)));
					}
				}
			}
		}
		
		return set;
	}
	
	public static void main(String[] args) {
		String s = "abaab";
		Set<String> palindromeSubstrings = getPalindromeSubstrings(s);
		System.out.println("Number of plaindrome substrings: " + palindromeSubstrings.size());
		System.out.println("Palindrome substrings: ");
		for (String tmp : palindromeSubstrings) {
			System.out.print(tmp + " ");
		}
	}
}
