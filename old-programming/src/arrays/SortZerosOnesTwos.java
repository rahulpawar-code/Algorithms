package arrays;

public class SortZerosOnesTwos {

	private static void printArray(int a[]) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private static void sortArray(int a[]) {
		if (a == null || a.length <= 0) {
			throw new IllegalArgumentException("Illegal arguemnt");
		}
		int ones = 0;
		int zeroIndex = -1;
		int twoIndex = a.length;
		
		int i = 0;
		while (i < a.length) {
			if (a[i] == 0) {
				a[++zeroIndex] = 0;
			} else if(a[i] == 2) {
				a[--twoIndex] = 2;
			} else {
				ones++;
			}
			printArray(a);
			
		}
		
		if (zeroIndex == -1 || twoIndex == a.length) {
			return;
		}
		
		System.out.println(zeroIndex + " " + ones + " " + twoIndex);
		
		for (i = zeroIndex + 1; i < twoIndex - 1; ++i) {
			a[i] = 1;
		}
	}
	
	public static void main(String[] args) {
		int a[] = {0, 2,  1,  2,  0};
		System.out.println("Before sorting: ");
		printArray(a);
		sortArray(a);
		System.out.println("After sorting: ");
		printArray(a);
	}
}
