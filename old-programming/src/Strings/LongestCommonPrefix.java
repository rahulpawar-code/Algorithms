package Strings;

import java.util.Arrays;

public class LongestCommonPrefix {
	private static String commonPrefixUtil(String str1, String str2) {
		if (str1 == null || str2 == null) {
			throw new IllegalArgumentException("Illegal argument");
		}
		StringBuilder prefix = new StringBuilder("");
		int n = Math.min(str1.length(), str2.length());
		int i = 0;
		while (i < n && str1.charAt(i) == str2.charAt(i)) {
			prefix.append(str1.charAt(i));
			i++;
		}
		
		return prefix.toString();
	}
	
	private static String longestPrefixInArray(String strings[]) {
		if (strings == null) {
			throw new IllegalArgumentException("Illegal argument");
		}
		String prefix = strings[0];
		for (int i = 1; i < strings.length; ++i) {
			prefix = commonPrefixUtil(prefix, strings[i]);
		}
		
		return prefix;
	}
	
	private static String longestPrefixInArray2(String strings[]) {
		if (strings == null) {
			throw new IllegalArgumentException("Illegal argument");
		}
		int length = Integer.MAX_VALUE;
		for (int i = 0; i < strings.length; ++i) {
			length = Math.min(length, strings[i].length());
		}
		
		StringBuilder prefix = new StringBuilder("");
		char c;
		for (int i = 0; i < length; ++i) {
			c = strings[0].charAt(i);
			for (int j = 1; j < strings.length; ++j) {
				if (c != strings[j].charAt(i)) {
					return prefix.toString();
				}
			}
			prefix.append(c);
		}
		
		return prefix.toString();
	}
	
	private static String longestPrefixInArray3(String strings[]) {
		if (strings == null) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		Arrays.sort(strings);
		return commonPrefixUtil(strings[0], strings[strings.length - 1]);
	}
	
	
	public static void main(String[] args) {
		String prefix = "";
		
		String[] strings = {"geeksforgeeks","geeks","geek","geezer", "g"}; 
		
		prefix = longestPrefixInArray(strings);
		System.out.println(prefix);
		
		prefix = longestPrefixInArray2(strings);
		System.out.println(prefix);
		
		prefix = longestPrefixInArray3(strings);
		System.out.println(prefix);

	}

}
