package Tree;

public class LowestCommonAncestor2 {
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
	
	private static Node findLCAUtil(Node root, int left, int right) {
		if (root == null) {
			return null;
		}
		
		if (root.data == left || root.data == right) {
			return root;
		}
		
		Node leftLCA = findLCAUtil(root.left, left, right);
		Node rightLCA = findLCAUtil(root.right, left, right);
		
		if (leftLCA != null && rightLCA != null) {
			return root;
		}
		
		return leftLCA != null ? leftLCA : rightLCA;
	}
	
	
	private static int findLCA(Node root, int left, int right) {
		Node lca = findLCAUtil(root, left, right);
		if (lca == null) {
			return -1;
		} else {
			return lca.data;
		}
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
