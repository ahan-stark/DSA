import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "{[{()}]}";
        boolean isValid = solution.checkIfValid(str);
        System.out.println("The given Parentheses is valid : " + isValid);
    }

    private static class Solution {
        private boolean checkIfValid(String str) {
            Stack<Character> stack = new Stack<>();
            char[] strArr = str.toCharArray();
            for (char ch : strArr) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty())
                        return false;
                    char popChar = stack.peek();
                    if ((ch == ')' && popChar == '(') || (ch == '}' && popChar == '{')
                            || (ch == ']' && popChar == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            if (!stack.isEmpty())
                return false;
            return true;
        }

    }
}
