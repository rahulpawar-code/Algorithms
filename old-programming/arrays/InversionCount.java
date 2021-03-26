package arrays;

import java.util.Arrays;

public class InversionCount {
	private static int inversionCountNaive(int a[]) {
		if (a == null || a.length <= 0) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		if (a.length == 1) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < a.length; ++i) {
			for (int j = i + 1; j < a.length; ++j) {
				if (a[i] > a[j]) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	private static int merge(int a[], int aux[], int low, int mid, int high) {
		int count = 0;
		
		int i = low;
		int j = mid + 1;
		int k = low;
		
		while (i <= mid && j <= high) {
			if (a[i] <= a[j]) {
				aux[k++] = a[i++];
			} else {
				aux[k++] = a[j++];
				count += (mid - i) + 1;
			}
		}
		
		while (i <= mid) {
			aux[k++] = a[i++];
		}
		
		for (i = low; i <= high; ++i) {
			a[i] = aux[i];
		}
		
		return count;
	}
	
	private static int mergeSort(int[] arr, int[] aux, int low, int high) {
		if (high == low) {	// if run size == 1
			return 0;
		}

		// find mid point
		int mid = (low + ((high - low) >> 1));
		int inversionCount = 0;

		// recursively split runs into two halves until run size == 1,
		// then merge them and return back up the call chain

		inversionCount += mergeSort(arr, aux, low, mid);		// split / merge left half
		inversionCount += mergeSort(arr, aux, mid + 1, high); // split / merge right half
		inversionCount += merge(arr, aux, low, mid, high);	// merge the two half runs

		return inversionCount;
	}
	
	public static void main(String[] args) {
		int a[] = { 1, 9, 6, 4, 5 };
		int count = inversionCountNaive(a);
		System.out.println("Inversion count by Naive method: " + count);
		
		int aux[] = Arrays.copyOf(a, a.length);
		count = mergeSort(a, aux, 0, a.length - 1);
		System.out.println("Inversion count by mergesort method: " + count);
		
		

	}

}
