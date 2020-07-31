package Queue;

import java.util.HashMap;

public class LRUCache2 {
	private static class Node {
		int value;
		int key;
		Node next;
		Node previous;
		
		public Node(int k, int v) {
			key = k;
			value = v;
			next = null;
			previous = null;
		}
		
		public void setValue(int v) {
			value = v;
		}
		
		public void printNode() {
			System.out.print("(" + key + ", " + value + ")");
		}
	}
	private static class Cache {
		int size, capacity ;
		Node head, tail;
		HashMap<Integer, Node> map;

		public Cache(int s) {
			capacity = s;
			size = 0;
			map = new HashMap<>();
			head = new Node(-1, -1);
			tail = new Node(-1, -1);
			head.next = tail;
			tail.previous = head;
			tail.next = null;
			head.previous = null;
		}
	
		public void deleteNode(Node node) {
			node.previous.next = node.next;
			node.next.previous = node.previous;
		}
		
		public void addFirst(Node node) {
			node.next = head.next;
			node.next.previous = node;
			head.next = node;
			node.previous = head;
		}
		
		public int get(int key) {
			if (map.containsKey(key)) {
				Node node = map.get(key);
				deleteNode(node);
				addFirst(node);
				return node.value;
			}
			
			return -1;
		}
		
		public void set(int key, int value) {
			if (map.containsKey(key)) {
				Node node = map.get(key);
				deleteNode(node);
				node.setValue(value);
				addFirst(node);
			} else {
				Node node = new Node(key, value);
				map.put(key, node);
				if (size != capacity) {
					size++;
				} else {
					Node last = tail.previous;
					deleteNode(last);
					map.remove(last.key);
				}
				addFirst(node);
			}
		}
		
		public void dispayCache() {
			if (head == null) {
				return;
			}
			for (Node tmp = head.next; tmp.next != tail; tmp = tmp.next) {
				tmp.printNode();
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int x;
		Cache cache = new Cache(2);
		
		cache.set(1, 10); // it will store a key (1) with value 10 in the cache.
		cache.set(2, 20); // it will store a key (1) with value 10 in the cache.
		
		x = cache.get(1); // returns 10
		System.out.println(x);
		
		cache.set(3, 30); // evicts key 2 and store a key (3) with value 30 in the cache.
		
		x = cache.get(2); // returns -1 (not found)
		System.out.println(x);
		
		cache.set(4, 40); // evicts key 1 and store a key (4) with value 40 in the cache.
		
		x = cache.get(1); // returns -1 (not found)
		System.out.println(x);
		
		x = cache.get(3); // returns 30
		System.out.println(x);
		cache.dispayCache();
		
		x = cache.get(4); // returns 40
		System.out.println(x);
		cache.dispayCache();
	}

}
