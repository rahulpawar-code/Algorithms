package BST;

public class CheckBST2 {
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
	
	private static Node insert(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}
		if (key < root.key) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}
		return root;
	}
	
	private static boolean isBST(Node root, Node previous) {
		if (root == null) {
			return true;
		}
		
		if (!isBST(root.left, previous)) {
			return false;
		}
		
		if (previous != null && previous.key > root.key) {
			return false;
		}
		previous = root;
		
		return isBST(root.right, previous);
	}
	
	private static boolean isBST(Node root) {
		return isBST(root, null);
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
