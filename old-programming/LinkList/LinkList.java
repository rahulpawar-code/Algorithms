package LinkList;

class Node {
	int data;
	Node next;
	
	public Node(int d) {
		data = d;
		next = null;
	}
}

public class LinkList {
	Node head;
	
	public LinkList() {
		head = null;
	}
	
	public void push(int d) {
		Node node = new Node(d);
		node.next = head;
		head = node;
	}
	
	public void append(int d) {
		Node node = new Node(d);
		if (head == null) {
			head = node;
			return;
		}
		
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = node;
	}
	
	public void insertAfter (Node previous, int d) {
		if (previous == null) {
			push(d);
			return;
		}
		
		Node node = new Node(d);
		node.next = previous.next;
		previous.next = node;
	}
	
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} 
		System.out.println("");
	}
	
	public void deleteKey(int d) {
		if (head != null && head.data == d) {
			head = head.next;
			return;
		}
		
		Node current = head;
		Node previous = null;
		
		while (current != null && current.data != d) {
			previous = current;
			current = current.next;
		}
		
		if (current == null) {
			return;
		}
		
		previous.next = current.next;
		current.next = null;
	}
	
	public void deleteNode(int index) {
		if (head == null || index < 0) {
			return;
		}
		
		Node temp = head;
		if (index == 0) {
			head = temp.next;
			temp.next = null;
		}
		
		for (int i = 0; temp != null && i < index - 1; ++i) {
			temp = temp.next;
		}
		
		if (temp == null) {
			return;
		}
		
		Node node = temp.next.next;
		temp.next = node;		
	}
	
	public void deleteList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.append(0);
		list.push(4);
		list.push(7);
		list.append(9);
		list.append(15);
		list.printList();
		list.deleteNode(3);
		list.printList();
	}
}
