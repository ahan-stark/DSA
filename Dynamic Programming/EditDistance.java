// Given two strings start and target, you need to determine the minimum number of operations required to convert the string start into the string target. The operations you can use are:

// Insert a character: Add any single character at any position in the string.

// Delete a character: Remove any single character from the string.

// Replace a character: Change any single character in the string to another character.

// The goal is to transform start into target using the fewest number of these operations.

// Input: start = "abcdefg", target = "azced"

// Output: 4

// Explanation: 

// To transform "abcdefg" into "azced", the following operations are required:

// 1. Replace 'b' with 'z': "abcdefg" -> "azcdefg"

// 2. Delete 'd': "azcdefg" -> "azcefg"

// 3. Delete 'f': "azcefg" -> "azceg"

// 4. Replace 'g' with 'd': "azceg" -> "azced"

// Thus, a total of 4 operations are needed.

import java.util.Arrays;

public class EditDistance {
    static int[][] dp;

    public static void main(String[] args) {
        String start = "planet", target = "plan";
        dp = new int[start.length()][target.length()];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        System.out
                .println(" Minimum operations : " + recursion(start, target, start.length() - 1, target.length() - 1));
    }

    private static int recursion(String start, String target, int index1, int index2) {
        if (index1 < 0 && index2 < 0)
            return 0;
        if (index1 < 0)
            return index2 + 1;
        if (index2 < 0)
            return index1 + 1;
        if (dp[index1][index2] != -1)
            return dp[index1][index2];
        if (start.charAt(index1) == target.charAt(index2)) {
            dp[index1][index2] = 0 + recursion(start, target, index1 - 1, index2 - 1);
        } else {
            int delChar = 1 + recursion(start, target, index1 - 1, index2);
            int insertChar = 1 + recursion(start, target, index1, index2 - 1);
            int replaceChar = 1 + recursion(start, target, index1 - 1, index2 - 1);
            dp[index1][index2] = Math.min(delChar, Math.min(insertChar, replaceChar));
        }
        return dp[index1][index2];
    }
}
// if both the chars are equal, shift both the indexes
// if not, we have 3 operations
// either delete from original str char, or insert what is in target to the
// original str char, or make replacement of char in original
// we make this all my maintaining indexes.
// in case of del op, we move the index - 1(original only) and add 1 value
// in case of replace op, we move both index - 1 and add 1 value, because after
// replacing we get equal, so move both
// for insertion, we insert the char to original string, after we
// insert, the index will increase by 1, because we are adding char, so dont
// move both the index after insertion, because after we insert lets say, we
// were in 3, after inserting index will be 4, in the next call we need to go to
// 3, but anyway we are on 3, so don't move original str index, move only target

// base case, if both covered return 0
// if we finish str1, and str2 is in between, than we have to add rest of str2
// to str1,so return that extra length
// if we finish str2, we need to operate rest of str1 to make it equal, so
// return that extra length