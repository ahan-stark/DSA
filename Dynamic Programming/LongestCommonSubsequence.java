// Given two strings str1 and str2, find the length of their longest common subsequence.
// A subsequence is a sequence that appears in the same relative order but not necessarily contiguous and a common subsequence of two strings is a subsequence that is common to both strings.
// Example 1
// Input: str1 = "bdefg", str2 = "bfg"
// Output: 3
// Explanation: The longest common subsequence is "bfg", which has a length of 3.
// Example 2
// Input: str1 = "mnop", str2 = "mnq"
// Output: 2
// Explanation: The longest common subsequence is "mn", which has a length of 2.

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "bdefg";
        String str2 = "bfg";
        System.out.println("LongestCommonSubsequence : " +  recursion(str1, str2));
        System.out.println("LongestCommonSubsequence : " +  tabulation(str1, str2));
    }

    private static int recursion(String str1, String str2) {
        int dp[][] = new int[str1.length()][str2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return findMax(str1, str2, 0, 0, dp);
    }

    private static int findMax(String str1, String str2, int index1, int index2, int[][] dp) {
        if (index1 == str1.length() || index2 == str2.length())
            return 0;
        if (dp[index1][index2] != -1)
            return dp[index1][index2];
        if (str1.charAt(index1) == str2.charAt(index2)) {
            dp[index1][index2] = 1 + findMax(str1, str2, index1 + 1, index2 + 1, dp);
        } else {
            int skip1 = findMax(str1, str2, index1 + 1, index2, dp);
            int skip2 = findMax(str1, str2, index1, index2 + 1, dp);
            dp[index1][index2] = Math.max(skip1, skip2);
        }
        return dp[index1][index2];
    }
    private static int tabulation(String str1, String str2){
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i = str1.length() - 1; i >= 0; i--){
            for(int j = str2.length() - 1; j >= 0; j--){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else{
                    int skip1 = dp[i + 1][j];
                    int skip2 = dp[i][j + 1];
                    dp[i][j] = Math.max(skip1, skip2);
                }
            }
        }
        return dp[0][0];
    }
}
