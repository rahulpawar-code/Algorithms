package arrays;

public class MaximumContinuousArraySum {
	private static int kadane(int a[]) {
		if (a == null || a.length <= 0) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		int maximumSoFar = a[0];
		int sumSoFar = a[0];
		for (int i = 1; i < a.length; ++i) {
			sumSoFar += a[i];
			
			if (sumSoFar < 0) {
				sumSoFar = 0;
			} else if (maximumSoFar < sumSoFar) {
				maximumSoFar = sumSoFar;
			}
		}
		
		return maximumSoFar;
	}
	
	public static void main(String[] args) {
		// int a[] = {1, 2, 3, -2, 5};
		int a[] = {-2, -2, -3, -4};
		
		int maximumSum = kadane(a);
		System.out.println("Maximum sum : " + maximumSum);

	}

}
