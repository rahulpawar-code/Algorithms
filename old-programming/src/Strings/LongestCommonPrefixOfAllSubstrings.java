/*
 * Problem Link: https://www.careercup.com/question?id=5740997808488448
 */

package Strings;

import java.util.LinkedList;
import java.util.List;

public class LongestCommonPrefixOfAllSubstrings {
	private static String commonPrefix(String target, String substring) {
		if (substring.isEmpty() || target.isEmpty()) {
			return "";
		}
		
		for (int i = substring.length(); i > 0; --i) {
			String tmp = substring.substring(0, i);
			if (target.startsWith(tmp)) {
				return tmp;
			}
		}
		return "";
	}
	
	private static List<String> allSubStrings(String s) {
		List<String> substrings = new LinkedList<>();
		for (int i = 0; i < s.length(); ++i) {
			for (int j = i + 1; j <= s.length(); ++j) {
				String tmp = s.substring(i, j);
				if (!substrings.contains(tmp)) {
					substrings.add(tmp);
				}
			}
		}
		return substrings;
	}
	
	public static void main(String[] args) {
		String string = "ababac";
		
		List<String> substrings = allSubStrings(string);
		
		
		for (String substring : substrings) {
			String commonPrefix = commonPrefix(string, substring);
			System.out.println("Substring: " + substring +", Prefix Length: " + commonPrefix.length() + ", Prefix: " + commonPrefix);
		}
	}
}