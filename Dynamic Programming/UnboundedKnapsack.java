// Given two integer arrays, val and wt, each of size N, representing the values 
// and weights of N items respectively, and an integer W, representing the maximum 
// capacity of a knapsack, determine the maximum value achievable by selecting a 
// subset of the items such that the total weight of the selected items does not 
// exceed the knapsack capacity W. The goal is to maximize the sum of the values of 
// the selected items while keeping the total weight within the knapsack's capacity

// An infinite supply of each item can be assumed

import java.util.Arrays;

public class UnboundedKnapsack {
    static int[][] dp;

    public static void main(String[] args) {
        int[] val = { 5, 11, 13 };
        int[] wt = { 2, 4, 6 };
        int W = 10;
        dp = new int[val.length + 1][W + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out
                .println("Max values that can be gained under the weight  " + W + " is : " + recursion(0, wt, val, W));
    }

    private static int recursion(int index, int[] wt, int[] val, int w) {
        if (index == wt.length)
            return 0;
        if (dp[index][w] != -1)
            return dp[index][w];
        int noPick = recursion(index + 1, wt, val, w);
        int pick = 0;
        if (w >= wt[index]) {
            pick = val[index] + recursion(index, wt, val, w - wt[index]);
        }
        dp[index][w] = Math.max(pick, noPick);
        return dp[index][w];
    }
}
// same pick and no pick algo
// since we have unlimited coins/vals, after choosing try to explore from the
// same index