// Given a string s, find the longest palindromic subsequence's length in s.

// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    static int dp[][];

    public static void main(String[] args) {
        String s = "bbbab";
        StringBuilder s2 = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            s2.append(s.charAt(i));
        }
        String str2 = s2.toString();
        dp = new int[s.length()][str2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("LongestPalindromicSubsequence : " + findMax(s, str2, 0, 0));
    }

    private static int findMax(String str1, String str2, int index1, int index2) {
        if (index1 == str1.length() || index2 == str2.length())
            return 0;
        if (dp[index1][index2] != -1)
            return dp[index1][index2];
        if (str1.charAt(index1) == str2.charAt(index2)) {
            dp[index1][index2] = 1 + findMax(str1, str2, index1 + 1, index2 + 1);
        } else {
            int skip1 = findMax(str1, str2, index1 + 1, index2);
            int skip2 = findMax(str1, str2, index1, index2 + 1);
            dp[index1][index2] = Math.max(skip1, skip2);
        }
        return dp[index1][index2];
    }
}
// If we carefully see, str = "azbcam" -> reverse this-> "macbza",
// After we reverse and make that string2, if we have a palindrome,
// we will get the same string subsequence again, after that find the
// longest common subsequence of str1 and str2.
// If we reverse "abc" -> "cba", we do not get same common subsequence,
// there it is not palindrome, max will be 1 in non palindrome case