// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
// In one step, you can delete exactly one character in either string.
// Input: word1 = "sea", word2 = "eat"
// Output: 2
// Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
// Input: word1 = "leetcode", word2 = "etco"
// Output: 4

import java.util.Arrays;

public class DeleteOperationForTwoStrings {
    static int[][] dp;

    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int lcs = findLCS(word1, word2, 0, 0, dp);
        int removeFromStr1 = word1.length() - lcs;
        int addToStr1 = word2.length() - lcs;
        System.out.println("Minimum operation to make word1 to word2 : " + (removeFromStr1 + addToStr1));
    }

    private static int findLCS(String str1, String str2, int index1, int index2, int[][] dp) {
        if (index1 == str1.length() || index2 == str2.length())
            return 0;
        if (dp[index1][index2] != -1)
            return dp[index1][index2];
        if (str1.charAt(index1) == str2.charAt(index2)) {
            dp[index1][index2] = 1 + findLCS(str1, str2, index1 + 1, index2 + 1, dp);
        } else {
            int skip1 = findLCS(str1, str2, index1 + 1, index2, dp);
            int skip2 = findLCS(str1, str2, index1, index2 + 1, dp);
            dp[index1][index2] = Math.max(skip1, skip2);
        }
        return dp[index1][index2];
    }
}
