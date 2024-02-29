import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strArr = { "hello", "hell", "hey" };
        String betterApproach = solution.betterApproach(strArr);
        System.out.println("Longest common prefix is : " + betterApproach);
        String optimalApproach = solution.optimalApproach(strArr);
        System.out.println("Longest common prefix is : " + optimalApproach);
    }

    private static class Solution {
        private String betterApproach(String[] str) {
            Arrays.sort(str);
            int min = Math.min(str[0].length(), str[str.length - 1].length());
            int i = 0;
            while (i < min && str[0].charAt(i) == str[str.length - 1].charAt(i)) {
                i = i + 1;
            }
            return str[0].substring(0, i);
        }

        private String optimalApproach(String[] str) {
            String res = str[0];
            for (int i = 1; i < str.length; i++) {
                while (str[i].indexOf(res) != 0) {
                    res = res.substring(0, res.length() - 1);
                }
                if (res.length() == 0)
                    return "";
            }
            return res;
        }

    }
}
