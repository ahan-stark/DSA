public class RemoveOutermostParanthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "(()())(())";
        String betterApproach = solution.betterApproach(str);
        System.out.println("Better Approach : " + betterApproach);
        String optimalApproach = solution.optimalApproach(str);
        System.out.println("Optimal Approach : " + optimalApproach);

    }

    private static class Solution {
        private String betterApproach(String str) {
            String res = "";
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' && (count = count + 1) > 1)
                    res += str.charAt(i);
                else if (str.charAt(i) == ')' && (count = count - 1) > 0)
                    res += str.charAt(i);
            }
            return res;
        }

        private String optimalApproach(String str) {
            String res = "";
            int openCount = 0;
            int closeCount = 0;
            int startIndex = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(')
                    openCount = openCount + 1;
                if (str.charAt(i) == ')')
                    closeCount = closeCount + 1;
                if (openCount == closeCount) {
                    res = res + str.substring(startIndex + 1, i);
                    startIndex = i + 1;
                }
            }
            return res;
        }

    }
}