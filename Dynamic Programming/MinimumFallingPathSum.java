// Given a 2d array called matrix consisting of integer values. Return the minimum path sum 
// that can be obtained by starting at any cell in the first row and ending at any cell in the last row.
// Movement is allowed only to the bottom, bottom-right, or bottom-left cell of the current cell.
// Input: matrix = [[1, 2, 10, 4], [100, 3, 2, 1], [1, 1, 20, 2], [1, 2, 2, 1]]

// Output: 6

// Explanation: One optimal route can be:-

// Start at 1st cell of 1st row -> bottom-right -> bottom -> bottom-left.

import java.util.Arrays;

public class MinimumFallingPathSum {
    static int[][] dp;

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };
        dp = new int[matrix.length][matrix[0].length];
        for (int[] arr : dp)
            Arrays.fill(arr, Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        for (int col = 0; col < matrix[0].length; col++) {
            min = Math.min(min, recursion(0, col, matrix));
        }
        System.out.println("Minimum path from the top row to any of the bootom row  in 3 direction is : " + min);
    }

    private static int recursion(int row, int col, int[][] matrix) {
        if (col < 0 || col >= matrix[0].length)
            return Integer.MAX_VALUE;
        if (row == matrix.length - 1)
            return matrix[row][col];
        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];

        int min = Integer.MAX_VALUE;
        int down = recursion(row + 1, col, matrix);
        if (down != Integer.MAX_VALUE)
            min = Math.min(min, matrix[row][col] + down);
        int left = recursion(row + 1, col - 1, matrix);
        if (left != Integer.MAX_VALUE)
            min = Math.min(min, matrix[row][col] + left);
        int right = recursion(row + 1, col + 1, matrix);
        if (right != Integer.MAX_VALUE)
            min = Math.min(min, matrix[row][col] + right);
        dp[row][col] = min;
        return dp[row][col];
    }
}
// do recursion from each of the last row and return when you reach the top row,
// follow top bottom approach