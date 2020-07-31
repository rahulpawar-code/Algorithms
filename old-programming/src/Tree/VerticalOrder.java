/*
 * https://www.techiedelight.com/vertical-traversal-binary-tree/
 */

package Tree;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrder {
	static class Node {
		int key;
		Node left;
		Node right;
		
		public Node(int k) {
			key = k;
			left = null;
			right = null;
		}
	}
	
	private static void addToMap(TreeMap<Integer, List<Integer>> map, int key, int value) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		} 
		map.get(key).add(value);
	}
	
	private static void printVertical(Node node, int distance, TreeMap<Integer, List<Integer>> map) {
		if (node == null) {
			return;
		}
		addToMap(map, distance, node.key);
		printVertical(node.left, distance - 1, map);
		printVertical(node.right, distance + 1, map);
	}
	
	public static void printVerticalOrder(Node root) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		printVertical(root, 0, map);
		for (Collection<Integer> collection : map.values()) {
			System.out.println(collection);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);
		root.right.left.right.left = new Node(9);
		root.right.left.right.right = new Node(10);

		printVerticalOrder(root);
	}
}
