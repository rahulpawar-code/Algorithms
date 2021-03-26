package Strings;

public class RecursiveRemoveDuplicate {
	private static String removeDuplicateRec(int index, String str) {
		if (index >= str.length() - 1) {
			return str;
		}
		if (str.charAt(index) == str.charAt(index + 1)) {
			int endIndex = index;
			for (int i = index; i < str.length(); ++i) {
				if (str.charAt(index) != str.charAt(i)) {
					endIndex = i - 1;
					break;
				}
			}
			if (endIndex == str.length()) {
				endIndex = str.length() - 1;
			}
			String s = removeDuplicateRec(index, str.substring(0, index) + str.substring(endIndex+1));
			return s;
		} else {
			return removeDuplicateRec(index + 1, str);
		}
		
	}
	
	private static String removeDuplicate(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException();
		}
		return removeDuplicateRec(0, str);
	}
	
	public static void main(String[] args) {
		String str = "geeksforgeek";
		String dup = "";
		
		str = "acaaabbbacdddd";
		dup = removeDuplicate(str);
		System.out.println(dup);
		
	}
}
