// Given two strings str1 and str2, find the length of their longest common substring.
// A substring is a contiguous sequence of characters within a string.
// Example 1
// Input: str1 = "abcde", str2 = "abfce"
// Output: 2
// Explanation: The longest common substring is "ab", which has a length of 2.

public class LongestCommonSubString {
    public static void main(String[] args) {
        String str1 = "abcdxyz", str2 = "xyzabcd";
        System.out.println("LongestCommonSubString : " + tabulation(str1, str2));
    }

    private static int tabulation(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for (int[] arr : dp) {
            for (int ele : arr) {
                ans = Math.max(ans, ele);
            }
        }
        return ans;
    }
}
// this problem is slightly different from longest subsequence
// In subsequence if we get the match, we check for i + 1. j + 1,meaning what
// was the case or value after choosing that, then we pick that value.
// if we dont get the match, we were checking both different index cases, one by
// choosing ith char and j + 1 index, and then other one i + 1th and jth index,
// meaning we try to inherit from previous possibilities
// since this is substring, if we get equal we check for next index, i + 1, j +
// 1 and inherit the value, if we got 2 different elem, point that as 0, as we
// need continous substring, therefore we will have a table, check the max value
// in the entire table