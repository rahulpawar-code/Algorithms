package Queue;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
	static Deque<Integer> queue;
	static HashSet<Integer> set;
	static int capacity;
	
	public LRUCache(int size) {
		capacity = size;
		queue = new LinkedList<>();
		set = new HashSet<>();
	}
	
	public static void refer(int data) {
		if (!set.contains((Integer)data)) {
			if (queue.size() == capacity) {
				int last = queue.removeLast();
				set.remove((Integer)last);
			}
		} else {
			queue.remove(data);
		}
		set.add(data);
		queue.push(data);
	}
	
	public static void display() {
		Iterator<Integer> it = queue.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LRUCache ca = new LRUCache(4); 
        LRUCache.refer(1); 
        LRUCache.refer(2); 
        LRUCache.refer(3); 
        LRUCache.refer(1); 
        LRUCache.refer(4); 
        LRUCache.refer(5); 
        LRUCache.display(); 
		

	}
}
