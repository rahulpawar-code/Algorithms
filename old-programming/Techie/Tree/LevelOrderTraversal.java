package Tree;

import java.util.Queue;
import java.util.ArrayDeque;

public class LevelOrderTraversal {
	private static void levelOrderUsingQueue(Node root) {
		if (root == null) {
			return;
		}
		
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				Node front = queue.poll();
				System.out.print(front.data + " ");
				
				if (front.left != null) {
					queue.add(front.left);
				}
				
				if (front.right != null) {
					queue.add(front.right);
				}
			}
			System.out.println("");
		}
	}
	
	private static boolean printLevel(Node root, int level) {
		if (root == null) {
			return false; 
		}
		
		if (level == 1) {
			System.out.print(root.data + " ");
			return true;
		}
		boolean right = printLevel(root.right, level - 1);
		boolean left = printLevel(root.left, level - 1);
		return left || right;
	}
	
	private static void printLeveOrderRec(Node root) {
		if (root == null) {
			return;
		}

		int level = 1;
		while (printLevel(root, level)) {
			level++;
			System.out.println("");
		}
	}
	
	
	public static void main(String[] args) {
		Node root = null;
		root = new Node(100);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(18);
		root.left.right = new Node(89);
		root.right.left = new Node(67);
		root.right.right = new Node(78);
		root.right.right.left = new Node(34);
		
		System.out.println("Level order travesal using queue");
		levelOrderUsingQueue(root);
		
		System.out.println("\nLevel order travesal using recursion");
		printLeveOrderRec(root);
	}

}
