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
}
// similar to unique paths 1, since there will be blocking add a extra check
// check like if we have block, if yes return 0