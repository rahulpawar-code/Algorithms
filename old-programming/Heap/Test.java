package Heap;

import Heap.MinHeap;

public class Test {

	public static void main(String[] args) {
		int element = 0;
		MinHeap heap = new MinHeap();
		heap.insert(20);
		heap.insert(2);
		heap.insert(5);
		heap.insert(10);
		heap.insert(15);
		element = heap.extractMin();
		System.out.println(element);
		element = heap.extractMin();
		heap.insert(1);
		
		
		System.out.println(element);
		element = heap.extractMin();
		System.out.println(element);
		element = heap.remove();
		System.out.println(element);
		element = heap.extractMin();
		System.out.println(element);
		element = heap.remove();
		System.out.println(element);
		
	}

}
