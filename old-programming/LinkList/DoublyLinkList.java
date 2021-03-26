package LinkList;

class DoublyNode {
	int data;
	DoublyNode next;
	DoublyNode back;
	
	public DoublyNode(int d) {
		data = d;
		next = null;
		back = null;
	}
}

public class DoublyLinkList {
	DoublyNode head;
	
	public DoublyLinkList() {
		head = null;
	}
	
	public void deleteList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void push(int d) {
		DoublyNode node = new DoublyNode(d);
		node.next = head;
		
		if (head != null) {
			head.back = node;
		}
		
		head = node;
	}
	
	public void append(int d) {
		DoublyNode node = new DoublyNode(d);
		
		if (head == null) {
			head = node;
			return;
		}
		
		DoublyNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		
		current.next = node;
		node.back = current;
	}
	
	public void insertAfter(DoublyNode node, int d) {
		if (node == null) {
			return;
		}
		
		DoublyNode newNode = new DoublyNode(d);
		newNode.next = node.next;
		newNode.back = node;
		node.next = node;
		
		if (newNode.next != null) {
			newNode.next.back = newNode;
		}
	}
	
	public void insertBefore(DoublyNode node, int d) {
		if (node == null) {
			return;
		}
		
		DoublyNode newNode = new DoublyNode(d);
		newNode.next = node;
		newNode.back = node.back;
		node.back = newNode;
		
		if (newNode.back != null) {
			newNode.back.next = newNode;
		}
	}
	
	public void printList(DoublyNode node) 
    { 
		DoublyNode last = null; 
        System.out.println("Traversal in forward Direction"); 
        while (node != null) { 
            System.out.print(node.data + " "); 
            last = node; 
            node = node.next; 
        } 
        System.out.println(); 
        System.out.println("Traversal in reverse direction"); 
        while (last != null) { 
            System.out.print(last.data + " "); 
            last = last.back; 
        } 
    } 

	public static void main(String[] args) {
		DoublyLinkList list = new DoublyLinkList();
		list.append(6);
		list.append(7);
		list.push(1);
		list.append(4);
		list.insertAfter(list.head.next, 8);
		list.printList(list.head);

	}
}
