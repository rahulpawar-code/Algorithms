package BST;

public class IdenticalTrees {
	static class Node {
		Node left;
		Node right;
		int data;
		
		public Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}
	
	private static boolean isIdentical(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		
		return (node1.data == node2.data) &&
				isIdentical(node1.left, node2.left) &&
				isIdentical(node1.right, node2.right);
	}
	
	private static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		if (data < root.data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}
	
	public static void main(String[] args) {
		int keys[] = {20, 8, 22, 4, 12, 10, 14};
		Node root1 = null;
		for (int k : keys) {
			root1 = insert(root1, k);
		}
		
		int keys2[] = {20, 8, 22, 4, 12, 10, 13};
		Node root2 = null;
		for (int k : keys2) {
			root2 = insert(root2, k);
		}
		
		boolean isEqual = isIdentical(root1, root2);
		if (isEqual) {
			System.out.println("Both trees are identical");
		} else {
			System.out.println("Trees are not identical");
		}

	}

}
