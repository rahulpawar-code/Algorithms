/*
 * Statement: Build a simple text editor class
 * Link: https://www.careercup.com/question?id=5726975948226560
 */

package Design;

import java.util.Stack;

class CharNode {
	char ch;
	CharNode previous;
	CharNode next;
	
	public CharNode(char ch) {
		this.ch = ch;
	}
}

enum Operations {
	LEFT, RIGHT, INSERT, DELETE
};

class EditOperation {
	Operations operationType;
	CharNode data;
	
	public EditOperation(Operations op, CharNode node) {
		operationType = op;
		data = node;
	}
}

class Editor {
	CharNode cursor;
	CharNode end;
	Stack<EditOperation> undoStack;
	
	public Editor() {
		undoStack = new Stack<>();
		end = new CharNode('\0');
		cursor = end;
	}
	
	public void moveCursorLeft() {
		// Cursor at beginning or a null list
		if (cursor.previous == null) {
			return;
		}
		
		cursor = cursor.previous;
		undoStack.push(new EditOperation(Operations.RIGHT, null));
	}
	
	public void moveCursorRight() {
		// Cursor at end or a null list
		if (cursor.next == null) {
			return;
		}
				
		cursor = cursor.next;
		undoStack.push(new EditOperation(Operations.LEFT, null));
	}
	
	private void insert(CharNode node) {
		CharNode prev = cursor.previous;
		node.next = cursor;
		cursor.previous = node;
		if (prev != null) {
			prev.next = node;
			node.previous = prev;
		}
	}
	
	public void insertCharacter(char ch) {
		CharNode node = new CharNode(ch);
		insert(node);
		undoStack.push(new EditOperation(Operations.DELETE, null));
	}
	
	private CharNode delete(CharNode current) {
		if (current.previous != null) {
			current.previous.next = cursor;
		}
		
		cursor.previous = current.previous;
		return current;
	}
	
	public void backspace() {
		if (cursor.previous == null) {
			return;
		}
		CharNode deletedNode = delete(cursor.previous);
		undoStack.push(new EditOperation(Operations.INSERT, deletedNode));
	}
	
	public void undo() {
		if (undoStack.isEmpty()) {
			return;
		}
		
		EditOperation editOperation = undoStack.pop();
		switch(editOperation.operationType) {
		case LEFT:
			cursor = cursor.previous;
			break;
		case RIGHT:
			cursor = cursor.next;
			break;
		case INSERT:
			insert(editOperation.data);
			break;
		case DELETE:
			delete(cursor.previous);
			break;
		default:
			return;
		}
	}
	
	// Traverse list and convert into text
	public String toString() {
		StringBuilder text = new StringBuilder();
		CharNode current = end.previous;
		
		if (cursor == end) {
			text.append("|");
		}
		
		while (current != null) {
			text.insert(0, current.ch);
			if (cursor == current) {
				text.insert(0, "|");
			}
			
			current = current.previous;
		}
		return text.toString();
	}
}

public class TextEditor {
	public static void main(String args[]) {
		Editor editor = new Editor();
		
		System.out.println("Start");
		System.out.println(editor.toString());
		
		System.out.println("Insert a");
		editor.insertCharacter('a');
		System.out.println(editor.toString());
		
		System.out.println("Insert b");
		editor.insertCharacter('b');
		System.out.println(editor.toString());
		
		System.out.println("Insert c");
		editor.insertCharacter('c');
		System.out.println(editor.toString());
		
		System.out.println("Move left");
		editor.moveCursorLeft();
		System.out.println(editor.toString());
		
		System.out.println("Move left");
		editor.moveCursorLeft();
		System.out.println(editor.toString());
		
		System.out.println("Backspace");
		editor.backspace();
		System.out.println(editor.toString());
		
		System.out.println("Undo");
		editor.undo();
		System.out.println(editor.toString());
		 
		System.out.println("Undo");
		editor.undo();
		System.out.println(editor.toString());
		
		System.out.println("Undo");
		editor.undo();
		System.out.println(editor.toString());
		
		System.out.println("Undo");
		editor.undo();
		System.out.println(editor.toString());
	}
}
