package arrays;

public class MinimumPlatform {
	private static int platforms(int arrival[], int departure[]) {
		if (arrival == null || departure == null || arrival.length != departure.length) {
			throw new IllegalArgumentException("Illeagl argument");
		}
		int current = 0;
		int max = 0;
		int i = 0;
		int j = 0;
		
		while (i < arrival.length && j < departure.length) {
			if (arrival[i] < departure[j]) {
				current++;
				i++;
				if (current > max) {
					max = current;
				}
			} else {
				current--;
				j++;
			}
		}
		
		
		return max;
	}

	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
	    int max = platforms(arr, dep);
	    System.out.println(max);

	}

}
