package BST;

public class LowestCommonAncestor {
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
	
	private static Node ancestorRec(Node root, int key1, int key2) {
		if (root == null) {
			return null;
		}

		if (key1 < root.data && key2 < root.data) {
			return ancestorRec(root.left, key1, key2);
		} 
		if (key1 > root.data && key2 > root.data) {
			return ancestorRec(root.right, key1, key2);
		}
		
		return root;
	}
	
	private static Node ancestorIter(Node root, int key1, int key2) {
		if (root == null) {
			return null;
		}
		while (root != null) {
			if (key1 > root.data && key2 > root.data) {
				root = root.right;
			} else if (key1 < root.data && key2 < root.data) {
				root = root.left;
			} else {
				break;
			}
		}
		return root;
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
	
	private static void inorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		inorder(root.left);
		inorder(root.right);
	}
	
	
	public static void main(String[] args) {
		int keys[] = {20, 8, 22, 4, 12, 10, 14};
		Node root = null;
		for (int k : keys) {
			root = insert(root, k);
		}
		Node node = null;
		node = ancestorRec(root, 10 , 14);
		System.out.println(node.data);
		node = ancestorRec(root, 10 , 22);
		System.out.println(node.data);
		node = ancestorRec(root, 8 , 14);
		System.out.println(node.data);
		
		node = ancestorIter(root, 10 , 14);
		System.out.println(node.data);
		node = ancestorIter(root, 10 , 22);
		System.out.println(node.data);
		node = ancestorIter(root, 8 , 14);
		System.out.println(node.data);
	}

}
