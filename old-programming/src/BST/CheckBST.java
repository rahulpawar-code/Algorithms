package BST;

public class CheckBST {
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
	
	private static boolean isBSTUtil(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		
		return ((min < root.data) && (root.data < max)) &&
				isBSTUtil(root.left, min, root.data) &&
				isBSTUtil(root.right, root.data, max);
	}
	
	private static boolean isBST(Node root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static Node insert(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}
		if (key < root.data) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}
		return root;
	}
	
	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 4);
		root = insert(root, 2);
		root = insert(root, 5);
		root = insert(root, 1);
		root = insert(root, 3);
  
        if (isBST(root)) 
            System.out.println("IS BST"); 
        else
            System.out.println("Not a BST"); 

	}

}
