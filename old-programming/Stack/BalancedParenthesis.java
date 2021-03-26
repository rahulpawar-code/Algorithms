package Stack;

import java.util.Scanner;
import java.util.Stack;


public class BalancedParenthesis {
	private static boolean isOpening(char c) {
		return c == '{' || c == '(' || c == '[';
	}
	
	private static boolean isClosing(char c) {
		return c == '}' || c == ')' || c == ']';
	}

	private static boolean isValidPair(char open, char close) {
		return (open == '(' && close == ')') || 
				(open == '{' && close == '}') || 
				(open == '[' && close == ']');
	}
	
	private static boolean isBalanced(String s) {
		if (s == null || s.length() == 0) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		boolean isBalanced = true;
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			
			if (isOpening(c)) {
				stack.push(c);
			}
			
			if (isClosing(c)) {
				if (stack.isEmpty()) {
					isBalanced = false;
					break;
				}
				char open = stack.pop();
				if (!isValidPair(open, c)) {
					isBalanced = false;
					break;
				}
			}
		}
		
		if (!stack.isEmpty()) {
			isBalanced = false;
		}
		
		return isBalanced;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean isBalanced = isBalanced(s);
		System.out.println(isBalanced);
		sc.close();
	}
}