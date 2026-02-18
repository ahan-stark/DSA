// Minimum insertions or deletions to convert string A to B
// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
// In one step, you can delete exactly one character in either string.

// Input: str1 = "kitten", str2 = "sitting"
// Output: 5
// Explanation: To transform "kitten" to "sitting", delete "k" and insert "s" to get "sitten", then insert "i" to get "sittin", and insert "g" at the end to get "sitting".

// Input: str1 = "flaw", str2 = "lawn"
// Output: 2
// Explanation: To transform "flaw" to "lawn", delete "f" and insert "n" at the end. Hence minimum number of operations required is 2".

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
// to make the string1 to string2
// we find the longest common subsequence between them
// once we get LCS, we need to remove the rest of the string chars from str1,
// removeFromStr1 = word1.length() - lcs;
// now we removed the extra chars from lcs from str1, and we need to add left
// out letters from str2 compared with LCS, and then we get total
// insertion/deletion
// str1 "sea" , str2 "eat", LCS -> "ea" > len = 2, we need to remove s from ea,
// LCS - str1.length() -> 1("s") , then add remaining present in the str2
// str2 -> "eat", LCS ->"ea" , str2.length() - LCS => 1("t"), this needs to be
// added to answer to make it equal
//so answer will be ans = removeFromStr1 + addToStr1