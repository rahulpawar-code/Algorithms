/*
 * https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 */

package arrays;

import java.util.HashSet;
import java.util.HashMap;



public class DigitsSequenceDecoding {
	private static boolean isValidIntegerPair(int a, int b) {
		return (a * 10 + b) <= 26; 
	}
	
	private static char getChar(int x) {
		return (char) ('a' - 1 + x);
	}
	
	public static HashSet<String> decoding(int array[]) {
		if (array == null || array.length == 0) {
			return null;
		}
		
		HashMap<Integer, HashSet<String>> map = new HashMap<>();
		HashSet<String> set1 = new HashSet<>();
		set1.add(String.valueOf(getChar(array[0])));		
		if (array.length == 1) {
			return set1;
		}
		map.put(0, set1);
		
		HashSet<String> set2 = new HashSet<>();
		set2.add(String.valueOf(getChar(array[0])) + String.valueOf(getChar(array[1])));
		set2.add(String.valueOf(getChar(array[0] * 10 + array[1])));
		if (array.length == 2) {
			return set2;
		}
		map.put(1, set2);

		
		for (int i = 2; i < array.length; ++i) {
			HashSet<String> decodedStrings = new  HashSet<>();
			set1 = map.get(i - 1);
			set2 = map.get(i - 2);
			
			if (array[i] != 0) {
				for (String s: set1) {
					decodedStrings.add(s + String.valueOf(getChar(array[i])));
				}
			}
			if (isValidIntegerPair(array[i - 1], array[i])) {
				for (String s: set2) {
					decodedStrings.add(s + String.valueOf(getChar(array[i - 1] * 10 + array[i]))); 
				}
			}
			
			if (decodedStrings.size() == 0) {
				map.put(i, set1);
			} else {
				map.put(i, decodedStrings);
			}
			
		}
		
		return map.get(array.length - 1);
	}
	
	public static HashSet<String> decoding2(int array[]) {
		if (array == null || array.length == 0) {
			return null;
		}
		
		HashSet<String> set1 = new HashSet<>();
		set1.add(String.valueOf(getChar(array[0])));		
				
		HashSet<String> set2 = new HashSet<>();
		HashSet<String> decodedStrings = new  HashSet<>();
		for (int i = 1; i < array.length; ++i) {
			if (array[i] != 0) {
				for (String s: set1) {
					decodedStrings.add(s + String.valueOf(getChar(array[i])));
				}
			}
			if (i > 1 && isValidIntegerPair(array[i - 1], array[i])) {
				for (String s: set2) {
					decodedStrings.add(s + String.valueOf(getChar(array[i - 1] * 10 + array[i]))); 
				}
			}
			set2 = (HashSet<String>) set1.clone();
			set1 = (HashSet<String>) decodedStrings.clone();
			decodedStrings.clear();
		}
		
		return set1;
	}
	
	private static void printStrings(HashSet<String> set) {
		if (set == null) {
			System.out.println("Set is null");
		}
		for (String s : set) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		int array[] = {1, 2, 1};
		HashSet<String> set = decoding(array);
		printStrings(set);
		System.out.println("------------");
		
		int array2[] = {1, 2, 3, 4};
		set = decoding(array2);
		printStrings(set);
		System.out.println("------------");
		
		int array3[] = {1, 2};
		set = decoding2(array3);
		printStrings(set);
		System.out.println("------------");
		
		int array4[] = {1, 2, 3, 4, 5, 0, 6, 7, 8, 9, 0};
		set = decoding(array4);
		printStrings(set);
		System.out.println("------------");
	}
}
