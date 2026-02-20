// Given two strings str1 and str2, find the shortest common supersequence.

// The shortest common supersequence is the shortest string that contains both str1 and str2 as subsequences.
//super sequence are formed by keeping the common terms once and placing the rest of the strings in subsequence such that it contains both the strings
// Input: str1 = "dynamic", str2 = "program"

// Output: "dynprogramic" or " progrdynamic"

// Explanation: The shortest common supersequence is "dynprogramic". It includes all characters from both "dynamic" and "program", with minimal overlap. For example, "dynamic" appears as "dyn...amic" and "program" appears as "...program..." within "dynprogramic".
public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String str1 = "dynamic", str2 = "program";
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        StringBuilder str = new StringBuilder();
        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    int right = dp[i][j + 1];
                    int down = dp[i + 1][j];
                    dp[i][j] = Math.max(right, down);
                }
            }
        }
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                str.append(str1.charAt(i));
                i++;
                j++;
            } else {
                if (dp[i + 1][j] >= dp[i][j + 1]) {
                    str.append(str1.charAt(i));
                    i++;
                } else {
                    str.append(str2.charAt(j));
                    j++;
                }
            }
        }
        while (i < str1.length()) {
            str.append(str1.charAt(i));
            i++;
        }
        while (j < str2.length()) {
            str.append(str2.charAt(j));
            j++;
        }
        System.out.println("ShortestCommonSupersequence : " + str.toString());
    }
}
// we need to find the supersequence
// first create the dp table using tabulation
// we know each row i will represent str1 and each col j will represent str2
// once we have the dp table ready, now we have to reverse engineer the way dp
// was formed
// if the chars are equals we will go to i + 1, j + 1 and add that char to new
// string, since it is common
// if its not equal , either the value came from right side that i, j + 1
// or from bottom i + 1, j, so which ever had big value, we move based on that
// if right we increase col, i, j + 1, if down we increase row, i + 1, j
// hence the row wise we have chars from str1 and col wise we have str2 char,
// after we make decision to move row + 1, add the row char to ans string,
// because we have passed that char, same way for col + 1, if we move, add col
// char and move
// we will end up parsing any one string based on dp values,
// hence add while loop to add the left out chars