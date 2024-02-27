import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "Hello there have a wonderful day";
        String betterApproach = solution.betterApproach(str);
        System.out.println("Better Approach : " + betterApproach);
        String optimalApproach = solution.optimalApproach(str);
        System.out.println("Optimal Approach  : " + optimalApproach);
    }

    private static class Solution {
        private String betterApproach(String str) {
            // to add a last space for operations
            str = str + " ";
            String ans = "";
            String dummy = "";
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    if (dummy != "")
                        stack.push(dummy);
                    dummy = "";
                } else {
                    dummy = dummy + str.charAt(i);
                }
            }
            while (stack.size() != 1) {
                ans = ans + stack.pop() + " ";
            }
            return ans + stack.pop();
        }

        private String optimalApproach(String str) {
            String ans = "";
            int i = 0;
            while (i < str.length()) {
                if (str.charAt(i) == ' ') {
                    i = i + 1;
                    continue;
                }
                int j = i + 1;
                while (j < str.length() && str.charAt(j) != ' ') {
                    j++;
                }
                ans = ans.length() == 0 ? str.substring(i, j) + ans : str.substring(i, j) + ' ' + ans;
                i = j + 1;
            }
            return ans;
        }

    }
}
