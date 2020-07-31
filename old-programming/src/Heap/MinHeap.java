package Heap;

public class MinHeap {
	int array[];
	int length;
	int size;
	
	public MinHeap(int l) {
		length = l;
		array = new int[length];
		size = 0;
	}
	
	public MinHeap() {
		length = 100;
		array = new int[length];
		size = 0;
	}
	
	private int getParent(int index) {
		return (index - 1) / 2;
	}
	
	private int getLeftChild(int index) {
		return 2 * index + 1;
	}
	
	private int getRightChild(int index) {
		return 2 * index + 2;
	}
	
	public int peak() {
		return array[0];
	}
	
	private void swap(int array[], int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void insert(int element) {
		array[size++] = element;
		int child = size - 1;
		int parent = getParent(child);
		
		while(child != 0 && array[parent] > array[child]) {
			swap(array, parent, child);
			child = parent;
			parent = getParent(child);
		}
	}
	
	private void minHeapify(int index) {
		int left = getLeftChild(index);
		int right = getRightChild(index);
		int smallest = index;
		if (left < size && array[left] < array[index]) {
			smallest = left;
		}
		if (right < size && array[right] < array[smallest]) {
			smallest = right;
		}
		
		if (smallest != index) {
			swap(array, index, smallest);
			minHeapify(smallest);
		}
	}
	
	public int extractMin() {
		if (size == 0) {
			return -1;
		}
		
		if (size == 1) {
			size--;
			return array[size];
		}
		
		int element = array[0];
		size--;
		array[0] = array[size];
		minHeapify(0);
		return element;
	}
	
	public int remove() {
		if (size == 0) {
			return -1;
		}
		
		if (size == 1) {
			size--;
			return array[size];
		}
		
		int element = array[0];
		size--;
		
		array[0] = array[size];
		
		int parent = 0;
		while (parent < size / 2) {
			int left = getLeftChild(parent);
			int right = getRightChild(parent);
			int smallest = parent;
			if (left < size && (array[parent] > array[left])) {
				smallest = left;
			} 
			if (right < size && (array[right] < array[smallest])) {
				smallest = right;
			}
			
			if (smallest != parent) {
				swap(array, smallest, parent);
				parent = smallest;
			} else {
				break;
			}
		}
		
		return element;
	}
}
