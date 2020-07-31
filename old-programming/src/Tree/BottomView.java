/*
 * https://www.techiedelight.com/print-bottom-view-of-binary-tree/
 */

package Tree;

import java.util.*;

public class BottomView {
	static class Node {
		int key;
		Node left;
		Node right;
		
		public Node(int d) {
			key = d;
			left = null;
			right = null;
		}
	}
	
	static class Pair<U, V> {
		public final U first;
		public final V second;
		
		private Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
		
		public static<U, V> Pair<U, V> of(U a, V b) {
			return new Pair<>(a, b);
		}
	}
	
	private static void updateRange(Integer[] range, int value) {
		if (value > range[1]) {
			range[1] = value;
		} else if (value < range[0]) {
			range[0] = value; 
		}
	}
	
	private static void printBottomView(Node root, HashMap<Integer, Pair<Integer, Integer>> map, int distance, int level, Integer[] range) {
		if (root == null) {
			return;
		}
		
		if (!map.containsKey(distance) || level >= map.get(distance).second) {
			map.put(distance, Pair.of(root.key, level));
			updateRange(range, distance);
		}
		
		printBottomView(root.left, map, distance - 1, level + 1, range);
		printBottomView(root.right, map, distance + 1, level + 1, range);
	}
	
	private static void printBottomView(Node root) {
		HashMap<Integer, Pair<Integer, Integer>> map = new HashMap<>();
		Integer[] range = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		printBottomView(root, map, 0, 0, range);
		
		for(int i = range[0]; i <= range[1]; ++i) {
			System.out.print(map.get(i).first + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);
		root.right.left.right.left = new Node(9);

		printBottomView(root);
	}
}