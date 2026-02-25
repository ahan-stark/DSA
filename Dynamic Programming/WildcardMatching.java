// iven a string str and a pattern pat, implement a pattern matching function that supports the following special characters:

// '?' Matches any single character.

// '*' Matches any sequence of characters (including the empty sequence).

// The pattern must match the entire string.

// Input: str = "xaylmz", pat = "x?y*z"

// Output: true

// Explanation: 

// The pattern "x?y*z" matches the string "xaylmz":

// - '?' matches 'a'

// - '*' matches "lm"

import java.util.Arrays;

public class WildcardMatching {
    static int dp[][];

    public static void main(String[] args) {
        String str = "xaylmz", pat = "x?y*z";
        dp = new int[str.length()][pat.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(
                "Is matching ?  : " + (recursion(str, pat, str.length() - 1, pat.length() - 1) == 1 ? true : false));
        ;
    }

    private static int recursion(String str, String pat, int index1, int index2) {
        if (index1 < 0 && index2 < 0)
            return 1;
        if (index2 < 0)
            return 0;
        if (index1 < 0) {
            for (int k = 0; k <= index2; k++) {
                if (pat.charAt(k) != '*')
                    return 0;
            }
            return 1;
        }
        if (dp[index1][index2] != -1)
            return dp[index1][index2];
        if (str.charAt(index1) == pat.charAt(index2)) {
            dp[index1][index2] = recursion(str, pat, index1 - 1, index2 - 1);
        } else if (pat.charAt(index2) == '?') {
            dp[index1][index2] = recursion(str, pat, index1 - 1, index2 - 1);
        } else if (pat.charAt(index2) == '*') {
            int zero = recursion(str, pat, index1, index2 - 1);
            int one = recursion(str, pat, index1 - 1, index2);
            dp[index1][index2] = (zero == 1 || one == 1) ? 1 : 0;
        } else {
            return 0;
        }
        return dp[index1][index2];
    }
}
