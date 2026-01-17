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
        System.out
                .println("Max values that can be gained under the weight  " + W + " is : " + tabulation(wt, val, W));
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

    private static int tabulation(int[] wt, int[] val, int W) {
        int dp[][] = new int[wt.length][W + 1];
        for (int i = 0; i <= W; i++) {
            dp[0][i] = val[0] * (i / wt[0]);
        }
        for (int i = 1; i < wt.length; i++) {
            for (int wgt = 0; wgt <= W; wgt++) {
                int noTake = dp[i - 1][wgt];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= wgt) {
                    take = val[i] + dp[i][wgt - wt[i]];
                }
                dp[i][wgt] = Math.max(take, noTake);
            }
        }
        return dp[dp.length - 1][W];
    }
}
// same pick and no pick algo
// since we have unlimited coins/vals, after choosing try to explore from the
// same index

// tabulation :
// Base case, for each wt in 0th index of dp, check how much we can put, lets
// say wt[0] = 8, from 8 -> 15, we can take val[0] once, 16 -> 23 we can take
// val[0] twice
// So we write as dp[0][i] = val[0] * (i / wt[0]) , where i crosses the wt[0],
// we get 1, 2, 3 etc ...7 / 8 -> 0, 12 / 8 -> 1, 23 / 8 -> 2.. we multiply it