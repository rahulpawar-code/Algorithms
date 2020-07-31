package Strings;

import java.util.LinkedList;
import java.util.List;


public class StringPermutation {
	private static void printList(List<String> list) {
		for (String s: list) {
			System.out.println(s);
		}
	}
	
	private static String swap(String s, int left, int right) {
		char temp;
		char[] array = s.toCharArray();
		temp = array[left];
		array[left] = array[right];
		array[right] = temp;
		return String.valueOf(array);
	}
	
	private static void permutationRec(String s, int left, int right, List<String> list) {
		if (left == right) {
			list.add(s); 
		} else {
			for (int i = left; i <= right; ++i) {
				s = swap(s, left, i);
				permutationRec(s, left + 1, right, list);
				s= swap(s, left, i);
			}
		}
	}
	
	private static List<String> permutation(String s) {
		if (s == null || s.length() <= 0) {
			throw new IllegalArgumentException("Illegal argument exception");
		}
		
		List<String> list = new LinkedList<>(); 
		permutationRec(s, 0, s.length() - 1, list);
		return list;
	}
	
	public static void main(String[] args) {
		String s = "ABC";
		List<String> permutations = permutation(s);
		printList(permutations);
	}

}
