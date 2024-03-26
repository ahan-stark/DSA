import java.util.Stack;

public class RemoveKdigits {
    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        Solution solution = new Solution();
        String ans = solution.getSolution(num, k);
        System.out.println(ans);
    }

    private static class Solution {
        private String getSolution(String str, int k) {
            if (k == str.length())
                return "0";
            Stack<Character> stack = new Stack<>();
            StringBuilder newStr = new StringBuilder();
            int i = 0;
            while (i < str.length()) {
                while (!stack.isEmpty() && stack.peek() > str.charAt(i) && k > 0) {
                    stack.pop();
                    k = k - 1;
                }
                stack.push(str.charAt(i));
                i++;
            }
            while (!stack.isEmpty() && k > 0) {
                stack.pop();
                k = k - 1;
            }
            while (!stack.isEmpty()) {
                newStr.append(stack.pop());
            }
            newStr.reverse();
            while (newStr.length() > 1 && newStr.charAt(0) == '0') {
                newStr.deleteCharAt(0);
            }
            return newStr.toString();
        }
    }
}
// if the stack is empty then directly push the element to stack

// if the ele is greater than stack.peek() that means its increasing, so do
// nothing and push

// if the stack.peek() is greater than ele, that means stack.peek() conatins 3
// and elem is 2, so we have to remove the stack.peek(), compare and keep
// removing untill k == 0

// if all the element are in increasing order, then we dont do pop at first
// iteration , in next step we check if k is still > 0, if that is the case pop
// the top k elements directly

// at th end make sure you dont return the string that starts with '0'
