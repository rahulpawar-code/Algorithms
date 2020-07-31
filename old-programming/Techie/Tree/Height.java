package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Height {
	private static int heightRec(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(heightRec(root.left), heightRec(root.right));
	}
	
	private static int heightIterative(Node root) {
		if (root == null) {
			return 0;
		}
		
		int height = 0;
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				Node front = queue.poll();
				
				if (front.left != null) {
					queue.add(front.left);
				}
				
				if (front.right != null) {
					queue.add(front.right);
				}
			}
			height++;
		}
		
		return height;
	}

	public static void main(String[] args) {
		Node root = null;
		root = new Node(10);
		root.left = new Node(15);
		root.right = new Node(20);
		root.left.left = new Node(30);
		root.left.right = new Node(25);
		root.right.right = new Node(40);
		root.right.left = new Node(46);
		root.right.left.left = new Node(58);
		
		System.out.println("Height of tree using recusive method : " + heightRec(root));
		System.out.println("Height of tree using iterative method : " + heightIterative(root));
	}
}
