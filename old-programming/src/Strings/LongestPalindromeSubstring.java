package Strings;

public class LongestPalindromeSubstring {
	private static String getString1(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("illegal argument");
		}
		if (str.length() == 1) {
			return str;
		}
		
		int start = -1;
		int maxLength = 1;
		int left, right;
		for (int i = 0; i < str.length(); ++i) {
			left = i - 1;
			right = i + 1;
			while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
				if (right - left + 1 > maxLength) {
					start = left;
					maxLength = right - left + 1;
				}
				--left;
				++right;
			}
			
			left = i - 1;
			right = i;
			while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
				if (right - left + 1 > maxLength) {
					start = left;
					maxLength = right - left + 1;
				}
				--left;
				++right;
			}
			
		}
		return str.substring(start, start + maxLength);
	} 
	
	public static void main(String[] args) {
		String str = "abaaba";
		String s;
		s = getString1(str);
		System.out.println(s);
	}
}
