// Given two integers m and n, representing the number of rows and columns of a 2d array named matrix. 
// Return the number of unique ways to go from the top-left cell (matrix[0][0]) 
// to the bottom-right cell (matrix[m-1][n-1]).

//  Movement is allowed only in two directions from a cell: right and bottom

// Input: m = 2, n = 4

// Output: 4

// Explanation: There are 4 unique ways to go from the top left to the bottom right cell.

// 1) down -> right -> right -> right

// 2) right -> down -> right -> right

// 3) right -> right -> down -> right

// 4) right -> right -> right -> down

import java.util.Arrays;

public class UniquePaths {
    private static int[][] dp;

    public static void main(String[] args) {
        int m = 2;
        int n = 4;
        dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("total unique paths : " + recursion(m - 1, n - 1));
        System.out.println("total unique paths : " + tabulation(m, n));

    }

    private static int recursion(int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        int left = recursion(i, j - 1);
        int up = recursion(i - 1, j);
        dp[i][j] = left + up;
        return dp[i][j];
    }

    private static int tabulation(int row, int col) {
        if (row < 0 || col < 0)
            return 0;
        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0)
                    continue;
                int up = i - 1 >= 0 ? dp[i - 1][j] : 0;
                int left = j - 1 >= 0 ? dp[i][j - 1] : 0;
                dp[i][j] = up + left;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}