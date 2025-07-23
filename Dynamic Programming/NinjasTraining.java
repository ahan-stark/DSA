// A ninja has planned a n-day training schedule. Each day he has to perform one
// of three activities -
// running, stealth training, or fighting practice. The same activity cannot be
// done on two consecutive days
// and the ninja earns a specific number of merit points, based on the activity
// and the given day.

// Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and
// matrix[i][2],
// represent the merit points associated with running, stealth and fighting
// practice, on the (i+1)th day respectively.
// Return the maximum possible merit points that the ninja can earn.
// Input: matrix = [[10, 40, 70], [20, 50, 80], [30, 60, 90]]

// Output: 210

// Explanation:

// Day 1: fighting practice = 70

// Day 2: stealth training = 50

// Day 3: fighting practice = 90

// Total = 70 + 50 + 90 = 210

// This gives the optimal points.

import java.util.Arrays;

public class NinjasTraining {
    public static int[][] dp;

    public static void main(String[] args) {
        int[][] matrix = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("Ninja's training with maximum merit point is  : "
                + recursion(matrix.length - 1, matrix[0].length, matrix));

    }

    private static int recursion(int curRow, int lastColIndex, int[][] matrix) {
        if (curRow == 0) {
            int max = 0;
            for (int i = 0; i < matrix[0].length; i++) {
                if (i != lastColIndex) {
                    max = Math.max(max, matrix[curRow][i]);
                }
            }
            return max;
        }
        if (dp[curRow][lastColIndex] != -1)
            return dp[curRow][lastColIndex];
        int max = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (i != lastColIndex) {
                int sum = matrix[curRow][i] + recursion(curRow - 1, i, matrix);
                max = Math.max(max, sum);
            }
        }
        dp[curRow][lastColIndex] = max;
        return dp[curRow][lastColIndex];
    }
}
// the logic is go with top down approach
// always better to start from bottom and come to 0
// the logic follows like initially say something as lastCol, whatever we have
// choosen as the prev col, we shouldn't consider the same column for choosing
// next, initailly we say out of bound of array col as prevCol and keep dp
// length as extra one because we at the end can store the values like this.
// initailly we loop through all the elements that is bottom
// and get the max in total
// start with first val in last row, in the next call dont consider from the
// same column, leave that and explore the other, go like this till we reach
// base case, base case is like get the max of first row leaving the last used
// column.
// lets say we have only one row, so initially we keep out of bound index that
// mat[0].length as the last column and if we loop in base case no one will
// match the lastIndex and max will be returned

// updation we do to dp is like for that curRow which col we are not
// considering, that is the dp state
// eg : in row2 if we have prevCol as 1, we find the best for all the cases
// except for 1 and update in dp[2][1], where 1 is not considred this is the
// meomized value