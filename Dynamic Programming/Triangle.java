// Given a 2d integer array named triangle with n rows. Its first row has 1 element and each 
// succeeding row has one more element in it than the row above it. Return the minimum falling 
// path sum from the first row to the last.

// Movement is allowed only to the bottom or bottom-right cell from the current cell.

// Input: triangle = [[1], [1, 2], [1, 2, 4]]

// Output: 3

// Explanation: One possible route can be:

// Start at 1st row -> bottom -> bottom.

import java.util.Arrays;

public class Triangle {
    static int dp[][];

    public static void main(String[] args) {
        int[][] triangle = { { 1 }, { 4, 7 }, { 4, 10, 50 }, { -50, 5, 6, -100 } };
        dp = new int[triangle.length][triangle.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("Minimum path from 0th row to last row is : " + recursion(0, 0, triangle));
        System.out.println("Minimum path from 0th row to last row is : " + tabulation(triangle));
    }

    private static int recursion(int row, int col, int[][] triangle) {
        if (col < 0 || col > row)
            return Integer.MAX_VALUE;
        if (row == triangle.length)
            return 0;

        if (dp[row][col] != -1)
            return dp[row][col];
        int bottomStraight = recursion(row + 1, col, triangle);
        if (bottomStraight != Integer.MAX_VALUE)
            bottomStraight = triangle[row][col] + bottomStraight;
        int bottomRight = recursion(row + 1, col + 1, triangle);
        if (bottomRight != Integer.MAX_VALUE)
            bottomRight = triangle[row][col] + bottomRight;
        dp[row][col] = Math.min(bottomStraight, bottomRight);
        return dp[row][col];
    }

    private static int tabulation(int[][] triangle) {
        int dp[][] = new int[triangle.length][triangle[triangle.length - 1].length];
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            dp[triangle.length - 1][i] = triangle[triangle.length - 1][i];
        }
        for (int row = triangle.length - 2; row >= 0; row--) {
            for (int col = 0; col < triangle[row].length; col++) {
                dp[row][col] = Math.min(triangle[row][col] + dp[row + 1][col],
                        triangle[row][col] + dp[row + 1][col + 1]);
            }
        }

        return dp[0][0];
    }
}

// start from first row find all paths and return the min
