/*
 * https://www.techiedelight.com/vertical-traversal-binary-tree/
 */

package Tree;

import java.util.*;

public class VerticalOrder2 {
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
	
	static class Pair <U, V> {
		public final U first;
		public final V second;
		
		private Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
		
		public static <U, V> Pair<U, V> of(U a, V b) {
			return new Pair<>(a, b);
		}
	}
	
	private static void addToMap(TreeMap<Integer, List<Integer>> map, Integer distance, Integer value) {
		if (!map.containsKey(distance)) {
			map.put(distance, new ArrayList<Integer>());
		}
		map.get(distance).add(value);
	}
	
	private static void printVertical(Node root) {
		if (root == null) {
			return;
		}
		
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		Queue<Pair<Node, Integer>> queue = new ArrayDeque<>();
		queue.add(Pair.of(root, 0));
		
		while(!queue.isEmpty()) {
			Pair<Node, Integer> pair = queue.poll();
			Node node = pair.first;
			int distance = pair.second;
			
			addToMap(map, distance, node.key);
			
			if (node.left != null) {
				queue.add(Pair.of(node.left, distance - 1));
			}
			
			if (node.right != null) {
				queue.add(Pair.of(node.right, distance + 1));
			}
		}
		
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

		printVertical(root);
	}

}
