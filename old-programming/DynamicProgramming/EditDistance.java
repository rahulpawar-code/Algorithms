package DynamicProgramming;

public class EditDistance {
	private static int distance(String X, int m, String Y, int n) {
		if (Math.min(m, n) == 0) {
			return Math.max(m, n);
		}
		
		int cost = (X.charAt(m - 1) == Y.charAt(n - 1)) ? 0 : 1;
		
		return Math.min(distance(X, m -1, Y, n - 1) + cost, Math.min(distance(X, m, Y, n - 1) + 1, distance(X, m -1, Y, n) + 1));
	}
	
	public static void main(String[] args) {
		String X = "kitten";
		String Y = "sitting";
		int m = X.length();
		int n = Y.length();
		int distance = distance(X, m, Y, n);
		System.out.println(distance);
	}

}
