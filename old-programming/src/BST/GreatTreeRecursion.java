package BST;

public class GreatTreeRecursion {
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
	
	static Node insertNode(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}

		if (data < root.data) {
			root.left = insertNode(root.left, data);
		} else {
			root.right = insertNode(root.right, data);
		}
		
		return root;
	}
	
	static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(Integer.toString(temp.data) + " ");
			temp = temp.right;
			if (temp == head) {
				break;
			}
		}
		System.out.println();
	}
	
	static void join(Node a, Node b) {
		a.right = b;
		b.left = a;
	}
	
	static Node append(Node a, Node b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		
		Node aLast = a.left;
		Node bLast = b.left;
		
		join(aLast, b);
		join(bLast, a);
		
		return a;
	}
	
	static Node treeToList(Node root) {
		if (root == null) {
			return null;
		}
		
		Node aList = treeToList(root.left);
		Node bList = treeToList(root.right);
		
		root.left = root;
		root.right = root;
		
		aList = append(aList, root);
		aList = append(aList, bList);
		
		return aList;
	}
	
	public static void main(String[] args) {
		int keys[] = {4, 2, 1, 3, 5};
		Node root = null;
		for (int key : keys) {
			root = insertNode(root, key);
		}
		inorder(root);
		System.out.println();
		
		Node head = treeToList(root);
		printList(head);

	}

}
