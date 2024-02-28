public class LargestOddNumberInString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "47";
        String longestOdd = solution.optimalApproach(str);
        System.out.println("Longest odd : " + longestOdd);

    }

    private static class Solution {
        private String optimalApproach(String str) {
            int i = str.length() - 1;
            while (i >= 0) {
                if (str.charAt(i) % 2 != 0)
                    return str.substring(0, i + 1);
                i--;
            }
            return "no odd";
        }

    }
}
