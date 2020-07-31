package arrays;

public class CountDigitSequence {
	private static boolean isValidPair(int a, int b) {
		return 10 * a + b <= 26;
	}
	
	private static int countDecodingRec(int digits[], int n) {
		if (n == 0) {
			return 1;
		}
		
		if (n == 1) {
			return 1;
		}
		if (digits[n - 1] == 0) {
			return 0; 
		}
		
		int count = 0;
		
		if (digits[n - 1] != 0) {
			count = countDecodingRec(digits, n - 1);
		}
		
		if (isValidPair(digits[n - 2], digits[n - 1])) {
			count += countDecodingRec(digits, n - 2);
		}
		return count;
	}
	
	private static int countDecoding(int digits[]) {
		if (digits == null || digits.length == 0) {
			return 0;
		}
		
		int n = digits.length;
		return countDecodingRec(digits, n);
	}
	
	public static void main(String[] args) {
		int[] digits = {1, 2, 3, 4};
		int count = countDecoding(digits);
		System.out.println(count);
		
		int array[] = {1, 2, 1};
		count = countDecoding(array);
		System.out.println(count);
		
		int array4[] = {1, 2, 3, 4, 5, 0, 6, 7, 8, 9};
		count = countDecoding(array4);
		System.out.println(count);
	}
}
