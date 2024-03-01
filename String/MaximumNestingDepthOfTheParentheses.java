public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(1+(2*3)+((8)/4))+1";
        int betterApproach = solution.betterApproach(s);
        System.out.println("Maximum Nesting : " + betterApproach);
    }

    private static class Solution {
        private int betterApproach(String str) {
            int max = 0;
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    count = count + 1;
                    max = Math.max(count, max);
                } else if (str.charAt(i) == ')')
                    count = count - 1;
            }
            return max;
        }

    }
}
