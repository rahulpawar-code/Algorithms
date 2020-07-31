package Tree;

import java.util.*;

public class LowestCommonAncestor {
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}
	
	private static boolean findPath(Node node, int target, List<Integer> list) {
		if (node == null) {
			return false;
		}
		
		list.add(node.data);
		if (node.data == target) {
			return true;
		}
		
		if (node.left != null && findPath(node.left, target, list)) {
			return true;
		}
		
		if (node.right != null && findPath(node.right, target, list)) {
			return true;
		}
		list.remove(list.size() - 1);
		return false;
	}
	
	
	private static int LCAUtil(Node node, List<Integer> list1, List<Integer> list2, int num1, int num2) {
		if (!findPath(node, num1, list1) || !findPath(node, num2, list2)) {
			return -1;
		}
		int i;
		for (i = 0; i < list1.size() && i < list2.size(); ++i) {
			if (list1.get(i).equals(list2.get(i))) {
				return list1.get(i);
			}
		}
		return -1;
	}
	
	private static int findLCA(Node root, int num1, int num2) {
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();
		path1.clear();
		path2.clear();
		return LCAUtil(root, path1, path2, num1, num2);
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
		
		System.out.println("LCA(4, 5): " + findLCA(root, 4,5));
		System.out.println("LCA(4, 5): " + findLCA(root, 40,50));

	}

}
