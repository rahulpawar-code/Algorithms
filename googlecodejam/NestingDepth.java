import java.util.*;

public class NestingDepth{
    private static String nestingString(String s) {
        Stack<Character> stack = new Stack<>();
        int previous = 0;

        // Scan each digit
        // Case 1: if current digit is less than previous push closing braces as many diff times
        // Case 2: if current digit is greater than prebious push opening braces as many diff times
        // Case 3: if current digit is equal to previous do nothing

        for (int i = 0; i < s.length(); ++i) {
            int current = s.charAt(i) - '0';

            if (previous > current) {
                // Case 1
                int diff = Math.abs(previous - current);
                while (diff > 0) {
                    stack.push(')');
                    diff--;
                }
            } else if (previous < current) {
                // Case 2
                int diff = Math.abs(previous - current);
                while (diff > 0) {
                    stack.push('(');
                    diff--;
                }
            }

            // Push current digit
            stack.push(s.charAt(i));
            previous = current;
        }

        // String is empty, push closing braces for last digit
        while (previous > 0) {
            stack.push(')');
            previous--;
        }

        // Empty the stack contents in string buffer
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // Reverse the string buffer content since stack poped out in reverse order
        String result = sb.reverse().toString();
        return result;
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; ++i) {
            String s = sc.next();
            System.out.print("Case #" + i + ": " + nestingString(s));
            System.out.println("");
        }
     }
}
