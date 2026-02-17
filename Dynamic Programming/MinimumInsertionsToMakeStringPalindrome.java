// Given a string s, find the minimum number of insertions needed to make it a palindrome. A palindrome is a sequence that reads the same backward as forward. You can insert characters at any position in the string.

// Input: s = "abcaa"

// Output: 2

// Explanation: Insert 2 characters "c", and "b" to make "abcacba", which is a palindrome.


import java.util.Arrays;

public class MinimumInsertionsToMakeStringPalindrome {
    static int dp[][];

    public static void main(String[] args) {
        String s = "abcaa";
        dp = new int[s.length() + 1][s.length() + 1];
        StringBuilder str = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            str.append(s.charAt(i));
        }
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        String s2 = str.toString();
        int maxSubSeq = findMaxSub(s, s2, 0, 0);
        int ans = s.length() - maxSubSeq;
        System.out.println("MinimumInsertionsToMakeStringPalindrome : " + ans);
    }

    private static int findMaxSub(String str1, String str2, int index1, int index2) {
        if (index1 == str1.length() || index2 == str2.length())
            return 0;
        if (dp[index1][index2] != -1)
            return dp[index1][index2];
        if (str1.charAt(index1) == str2.charAt(index2)) {
            dp[index1][index2] = 1 + findMaxSub(str1, str2, index1 + 1, index2 + 1);
        } else {
            int skip1 = findMaxSub(str1, str2, index1 + 1, index2);
            int skip2 = findMaxSub(str1, str2, index1, index2 + 1);
            dp[index1][index2] = Math.max(skip1, skip2);
        }
        return dp[index1][index2];
    }
}

// The logic, reverse the given string, once you have s1(original) ,
// s2(reversed), to know the max len of palindrome, check the maximum common
// subsequence, here we will obtain the maximum palindrome available, the left
// out values are the chars we need to add to make the entire string palindrome
// so ans will totalLen - maxSubSeqPalindrome
// abcaa - > aacba , maxLen of the common subseq -> aaa -> 3, left out are
// cb(2), hence we need to add bc to this string at some loc to make it proper
// palindrome