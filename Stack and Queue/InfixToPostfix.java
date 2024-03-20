import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String val = "(a+b)*(c-d)";
        String postFix = solution.convert(val);
        System.out.println("Infix : " + val + " converted to Postfix is : " + postFix);
    }

    private static class Solution {
        private String convert(String str) {
            Stack<Character> stack = new Stack<>();
            StringBuilder postFix = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (Character.isLetterOrDigit(str.charAt(i))) {
                    postFix.append(str.charAt(i));
                } else if (str.charAt(i) == '(') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postFix.append(stack.pop());
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && (checkPrecedence(str.charAt(i)) <= checkPrecedence(stack.peek()))) {
                        postFix.append(stack.pop());
                    }
                    stack.push(str.charAt(i));
                }
            }
            while (!stack.isEmpty()) {
                if (stack.peek() == '(') {
                    System.out.println("Invalid Expression");
                    System.exit(0);
                } else {
                    postFix.append(stack.pop());
                }
            }
            return postFix.toString();
        }

        private int checkPrecedence(Character c) {
            if (c == '+' || c == '-')
                return 1;
            if (c == '*' || c == '/')
                return 2;
            if (c == '^')
                return 3;
            return -1;
        }
    }
}
