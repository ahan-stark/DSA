// Given an m x n 2d array named matrix, where each cell is either 0 or 1. 
// Return the number of unique ways to go from the top-left cell (matrix[0][0]) to 
// the bottom-right cell (matrix[m-1][n-1]). A cell is blocked if its value is 1, 
// and no path is possible through that cell.

// Movement is allowed in only two directions from a cell - right and bottom.
// Input: matrix = [[0, 0, 0], [0, 1, 0], [0, 0, 0]]

// Output: 2

// Explanation: The two possible paths are:

// 1) down -> down-> right -> right

// 2) right -> right -> down -> down

import java.util.Arrays;

public class UniquePaths2 {
    static int dp[][];

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        dp = new int[matrix.length][matrix[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("The total ways to reach ending point in unique way is : "
                + recursion(matrix.length - 1, matrix[0].length - 1, matrix));
        System.out.println("The total ways to reach ending point in unique way is : " + tabulation(matrix));

    }

    private static int recursion(int i, int j, int mat[][]) {
        if (i < 0 || j < 0)
            return 0;
        if (mat[i][j] == 1)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        int left = recursion(i, j - 1, mat);
        int up = recursion(i - 1, j, mat);
        dp[i][j] = left + up;
        return dp[i][j];
    }

    private static int tabulation(int mat[][]) {
        int dp[][] = new int[mat.length][mat[0].length];
        if (mat[0][0] == 1)
            return 0;
        dp[0][0] = 1;
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (row == 0 && col == 0)
                    continue;
                if (mat[row][col] == 1) {
                    dp[row][col] = 0;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (col - 1 >= 0) {
                    left = dp[row][col - 1];
                }
                if (row - 1 >= 0) {
                    up = dp[row - 1][col];
                }
                dp[row][col] = left + up;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
// similar to unique paths 1, since there will be blocking add a extra check
// check like if we have block, if yes return 0