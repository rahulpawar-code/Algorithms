package Others;

import java.util.HashSet;
import java.util.Set;

/* Problem Statement:
 * Find all distinct (or count) ngrams in a string
 * 
 * Link:
 * https://www.careercup.com/question?id=5632054486630400
 */

public class NGram {
	private static Set<String> distinctNGrams(String s, int n) {
		if (n <= 0 || s == "" || n > s.length()) {
			throw new IllegalArgumentException("Invalid argument value");
		}
		
		Set<String> ngrams = new HashSet<>();
		
		for (int i = 0; i + n - 1 < s.length(); ++i) {
			ngrams.add(s.substring(i, i + n));
		}
		
		return ngrams;
	}
	
	private static void printList(Set<String> ngrams) {
		for (String s: ngrams) {
			System.out.print(s + " ");
		}
	}
	
	public static void main(String args[]) {
		int n;
		String mailId = "testing123";
		Set<String> ngrams;
		
		n = 1;
		ngrams = distinctNGrams(mailId, n);
		System.out.print(n + "-grams in " + mailId + ", count: " +  ngrams.size() + ", ngrams: ");
		printList(ngrams);
		System.out.println("");
		
		n = 3;
		ngrams = distinctNGrams(mailId, n);
		System.out.print(n + "-grams in " + mailId + ", count: " +  ngrams.size() + ", ngrams: ");
		printList(ngrams);
		System.out.println("");
		
		n = 9;
		ngrams = distinctNGrams(mailId, n);
		System.out.print(n + "-grams in " + mailId + ", count: " +  ngrams.size() + ", ngrams: ");
		printList(ngrams);
		System.out.println("");
		
		n = 10;
		ngrams = distinctNGrams(mailId, n);
		System.out.print(n + "-grams in " + mailId + ", count: " +  ngrams.size() + ", ngrams: ");
		printList(ngrams);
		System.out.println("");
		
	}
}
