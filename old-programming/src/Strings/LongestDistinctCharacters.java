package Strings;

public class LongestDistinctCharacters {
	public static int longestSubstring(String str) {
		if (str == null || str.length() <= 0) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		int visited[] = new int[256];
		int currentLength = 1;
		int maxLength = currentLength;
		
		for (int i = 0; i < visited.length; ++i) {
			visited[i] = -1;
		}
		
		visited[str.charAt(0)] = 0;
		
		for (int i = 1; i < str.length(); ++i) {
			char c = str.charAt(i);
			int previousIndex = visited[c]; 
			
			if (previousIndex == -1 || visited[c] < i - currentLength) {
				currentLength++;
			} else {
				maxLength = Math.max(maxLength, currentLength);
				currentLength = i - previousIndex;
			}
			visited[c] = i;
		}
		
		return Math.max(maxLength, currentLength);
	}
	
	
	public static void main(String[] args) {
		String str = "ABDEFGABEF"; 
        System.out.println("The input string is " + str); 
        int len = longestSubstring(str);
        System.out.println("The length of "+ "the longest non repeating character is " + len);
	}

}
