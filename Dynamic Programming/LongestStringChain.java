// You are given an array of words where each word consists of lowercase English letters.

// wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

// For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
// Input: words = ["a","b","ba","bca","bda","bdca"]
// Output: 4
// Explanation: One of the longest word chains is ["a","ba","bda","bdca"].

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public static void main(String[] args) {
        String words[] = { "a", "b", "ba", "bca", "bda", "bdca" };
        System.out.println("LongestStringChain :  " + longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {
        int maxVal = 1;
        Arrays.sort(
                words,
                new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return Integer.compare(s1.length(), s2.length());
                    }
                });
        int dp[] = new int[words.length];
        Arrays.fill(dp, 1);
        for (int curIndex = 1; curIndex < words.length; curIndex++) {
            for (int prevIndex = 0; prevIndex < curIndex; prevIndex++) {
                if (checkIfSubstring(words[prevIndex], words[curIndex]) == true && 1 + dp[prevIndex] >= dp[curIndex]) {
                    dp[curIndex] = dp[prevIndex] + 1;
                }
            }
            if (dp[curIndex] > maxVal) {
                maxVal = dp[curIndex];
            }
        }
        return maxVal;
    }

    private static boolean checkIfSubstring(String s1, String s2) {
        if (s2.length() != s1.length() + 1)
            return false;
        int i = 0, j = 0;
        boolean skipped = false;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if (skipped)
                    return false;
                skipped = true;
                j++;
            }
        }
        return true;
    }
}

// Sort in length ascending wise for comparision
// same logic as Print Longest Increasing Subsequence & Largest Divisible Subset
// maintain dp array with long chain so for all the prevIndex checking, and keep
// the max one
// max we can replace / insert one char, so take a variable named skipped and
// set it to true, if we find a mismatch, updated it but only once it is allowed