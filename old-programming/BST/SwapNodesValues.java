package BST;



public class SwapNodesValues {
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
	
	static Node first;
	static Node middle;
	static Node last;
	static Node prev;
	
	static void correctBSTUtil(Node root) {
		if (root == null) {
			return;
		}
		
		correctBSTUtil(root.left);
		
		if (prev != null && prev.data > root.data) {
			if (first == null) {
				first = prev;
				middle = root;
			} else {
				last = root;
			}
		}
		
		prev = root;
		correctBSTUtil(root.right);
	}
	
	static void correctBST(Node root) {
		if (root == null) {
			return;
		}
		
		first = middle = last = prev = null;
		
		correctBSTUtil(root);
		if (first != null && last != null) {
			int temp = first.data;
			first.data = last.data;
			last.data = temp;
		} else if (first != null && middle != null) {
			int temp = first.data;
			first.data = middle.data;
			middle.data = temp;
		}
	}
	
	static void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(10); 
        root.right = new Node(2); 
        root.left.left = new Node(1); 
        root.left.right = new Node(3); 
        root.right.right = new Node(12); 
        root.right.left = new Node(7); 

        System.out.println("Before swapping: ");
        printInorder(root);
        correctBST(root);
        System.out.println("\nAfter swapping: ");
        printInorder(root);
	}
}
