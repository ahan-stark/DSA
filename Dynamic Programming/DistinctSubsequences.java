// Given two strings s and t, return the number of distinct subsequences of s which equals t.

// The test cases are generated so that the answer fits on a 32-bit signed integer.
// Input: s = "babgbag", t = "bag"
// Output: 5
// Explanation:
// As shown below, there are 5 ways you can generate "bag" from s.
// 0,1,3 -> "bag"
// 0,1,6 -> "bag"
// 0,5,6 -> "bag"
// 2,5,6 -> "bag"
// 4,5,6 -> "bag"

import java.util.Arrays;

public class DistinctSubsequences {
    static int[][] dp;

    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
        dp = new int[s.length()][t.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("Distinct Subsequences : " + recursion(s, t, s.length() - 1, t.length() - 1));
    }

    private static int recursion(String s, String t, int index1, int index2) {
        if (index2 < 0)
            return 1;
        if (index1 < 0)
            return 0;
        if (dp[index1][index2] != -1)
            return dp[index1][index2];
        if (s.charAt(index1) == t.charAt(index2)) {
            int pick = recursion(s, t, index1 - 1, index2 - 1);
            int noPick = recursion(s, t, index1 - 1, index2);
            dp[index1][index2] = (pick + noPick) % ((int) 1e9 + 7);
        } else {
            dp[index1][index2] = recursion(s, t, index1 - 1, index2);
        }
        return dp[index1][index2];
    }
}
// Base case, if we parse the entire str2, return 1.
// If we get equal chars, choose that and explore, meaning try finding match and
// also skip that, try finding. If not equal, just skip that index