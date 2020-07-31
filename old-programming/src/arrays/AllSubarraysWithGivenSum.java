package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllSubarraysWithGivenSum {
	private static void printArray(int a[], int from, int to) {
		for(int i = from; i <= to; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	private static<K, V> void insert(Map<K, List<V>> map, K key, V value) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		}
		map.get(key).add(value);
	}
	
	private static void printAllSubarrays(int a[], int sum) {
		if (a == null || a.length <= 0) {
			throw new IllegalArgumentException("Illegal argument to function");
		}
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		int sumSoFar = 0;
		insert(map, 0, -1);
		
		for (int i = 0; i < a.length; ++i) {
			sumSoFar += a[i];
			
			if (map.containsKey(sumSoFar - sum)) {
				List<Integer> value = map.get(sumSoFar - sum);
				for (int v : value) {
					printArray(a, v + 1, i);
				}
			}
			
			insert(map, sumSoFar, i);
		}
	}
	
	public static void main(String[] args) {
		int sum = 7;
		int a[] = {3, 4, -7, 1, 3, 3, 1, -4};
		printAllSubarrays(a, sum);
	}
}
