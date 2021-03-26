package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ShortestCommonSupersequence {
	public static int SCSLength(String X, String Y, int m, int n) {
		if (m == 0 || n == 0) {
			return m + n;
		}
		if (X.charAt(m -1) == Y.charAt(n - 1)) {
			return  1 + SCSLength(X, Y, m - 1, n - 1);
		}
		return 1 + Math.min(SCSLength(X, Y, m - 1, n), SCSLength(X, Y, m, n - 1));
	}
	
	public static int SCSLength(String X, String Y, int m, int n, Map<String, Integer> map) {
		if (m == 0 || n == 0) {
			return m + n;
		}
		
		String key = m + " | " + n;
		if (!map.containsKey(key)) {
			int value = 0;
			if (X.charAt(m -1) == Y.charAt(n - 1)) {
				value =  1 + SCSLength(X, Y, m - 1, n - 1);
			} else {
				value =  1 + Math.min(SCSLength(X, Y, m - 1, n), SCSLength(X, Y, m, n - 1));
			}
			map.put(key, value);
		}
		
		return map.get(key);
	}
	
	public static int SCSLength(String X, String Y) {
		int m = X.length();
		int n = Y.length();
		int length[][] = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; ++i) {
			for (int j = 0; j <= n; ++j) {
				if (i == 0 || j == 0) {
					length[i][j] = i + j;
				} else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					length[i][j] = 1 + length[i - 1][j -1]; 
				} else {
					length[i][j] = 1 + Math.min(length[i - 1][j], length[i][j -1]);
				}
			}
		}
		
		return length[m][n];
	}
	
	public static void main(String[] args) {
		String X = "ABCBDAB";
		String Y = "BDCABA";
		HashMap<String, Integer> map = new HashMap<>();
		int length = SCSLength(X, Y, X.length(), Y.length());
		System.out.println(length);
		length = SCSLength(X, Y, X.length(), Y.length(), map);
		System.out.println(length);
		length = SCSLength(X, Y);
		System.out.println(length);	
	}
}
