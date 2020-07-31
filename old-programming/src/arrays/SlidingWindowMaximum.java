package arrays;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	private static void slidingWindowMaximum(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k <= 0) {
			throw new IllegalArgumentException("Illegal arguments");
		}
		
		for (int i = 0; i + k <= arr.length; ++i) {
			int max = arr[i];
			for (int j = 1; j < k; ++j) {
				max = Math.max(arr[i + j], max);
			}
			System.out.print(max + " ");
		}
		System.out.println();
	}
	
	private static void slidingWindowMaximum2(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k <= 0) {
			throw new IllegalArgumentException("Illegal arguments");
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder()); 
		
		for (int i = 0; i < k; ++i) {
			queue.add(arr[i]);
		}
		
		for (int i = k; i < arr.length; ++i) {
			System.out.print(queue.peek() + " ");
			queue.add(arr[i]);
			queue.remove((Integer)arr[i - k]);
			
		}
		System.out.print(queue.peek() + " ");
		System.out.println();
	}
	
	private static void slidingWindowMaximum3(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k <= 0) {
			throw new IllegalArgumentException("Illegal arguments");
		}
		
		Deque<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < k; ++i) {
			while (!queue.isEmpty() && arr[queue.peekLast()] < arr[i]) {
				queue.removeLast();
			}
			queue.addLast(i);
		}
		
		for (int i = k; i < arr.length; ++i) {
			System.out.print(arr[queue.peekFirst()] + " ");
			while (!queue.isEmpty() && queue.peek() <= i - k) {
				queue.removeFirst();
			}
			
			while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]) {
				queue.removeLast();
			}
			
			queue.addLast(i);
		}
		
		System.out.print(arr[queue.peekFirst()] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3; 
        slidingWindowMaximum(arr, k);
        slidingWindowMaximum2(arr, k); 
        slidingWindowMaximum3(arr, k); 
	}

}
