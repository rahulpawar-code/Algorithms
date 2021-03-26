package BST;

public class FixTwoNodes {
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
	
	static class NodeWrapper {
		Node node;
		
		public NodeWrapper() {
			this.node = null;
		}
		
		public NodeWrapper(int data) {
			this.node = new Node(data);
		}
	}
	
	static void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);
	}
	
	static Node insert(Node root, int value) {
		if (root == null) {
			return new Node(value);
		}
		
		if (value < root.data) {
			root.left = insert(root.left, value);
		} else {
			root.right = insert(root.right, value);
		}
		
		return root;
	}
	
	static void correctBSTUtil(Node root, NodeWrapper x, NodeWrapper y, NodeWrapper prev) {
		if (root == null) {
			return;
		}
		
		correctBSTUtil(root.left, x, y, prev);
		
		if (root.data < prev.node.data) {
			if (x.node == null) {
				x.node = prev.node;
			}
			
			y.node = root;
		}
		
		prev.node = root;
		correctBSTUtil(root.right, x, y, prev);
	}
	
	static void correctBST(Node root) {
		if (root == null) {
			return;
		}
		
		NodeWrapper x = new NodeWrapper();
		NodeWrapper y = new NodeWrapper();
		NodeWrapper prev = new NodeWrapper(Integer.MIN_VALUE);
		correctBSTUtil(root, x, y, prev);
		
		if (x.node != null && y.node != null) {
			swapNodeValues(x.node, y.node);
		}
	}
	
	static void swapNodeValues(Node first, Node second) {
		int temp = first.data;
		first.data = second.data;
		second.data = temp;
	}
	
	public static void main(String[] args) {
		int keys[] = {15, 10, 20, 8, 12, 16, 25};
		Node root = null;
		for (int key : keys) {
			root = insert(root, key);
		}
		System.out.println("Before fix");
		swapNodeValues(root.left, root.right);
		inorderTraversal(root);
		System.out.println("\nAfter fix");
		correctBST(root);
		inorderTraversal(root);
	}

}
