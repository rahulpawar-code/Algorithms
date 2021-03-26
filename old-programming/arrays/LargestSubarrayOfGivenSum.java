package arrays;

public class LargestSubarrayOfGivenSum {
	private static int largestSubarray(int arr[], int s) {
		if (arr == null || arr.length <= 0) {
			throw new IllegalArgumentException("IllegalArgument");
		}
		
		int sum = 0;
		int startIndex = -1;
		int maxLength = -1;
		
		for (int i = 0; i < arr.length - 1; ++i) {
			sum = arr[i];
			
			for (int j = i + 1; j < arr.length; ++j) {
				sum += arr[j];
				
				if (sum == s && (j - i + 1) > maxLength) {
					maxLength = j - i + 1;
					startIndex = i;
				}
			}
		}
		
		int endIndex = startIndex + maxLength - 1;
		
		if (maxLength == -1) {
			System.out.println("No index found");
		} else  {
			System.out.println("startIndex : " + startIndex + " , endIndex : " + endIndex + " , maxlength: " + maxLength);
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 0, 0, 1, 0, 1, 1};
		int sum = 1;
		largestSubarray(arr, sum);
		

	}

}
