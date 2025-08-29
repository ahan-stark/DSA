// Given two integer arrays, val and wt, each of size N, which represent the values and 
// weights of N items respectively, and an integer W representing the maximum capacity of a
//  knapsack, determine the maximum value achievable by selecting a subset of the items such 
//  that the total weight of the selected items does not exceed the knapsack capacity W.
// Each item can either be picked in its entirety or not picked at all (0-1 property). The goal 
// is to maximize the sum of the values of the selected items while keeping the total weight within
//  the knapsack's capacity.

// Input: val = [60, 100, 120], wt = [10, 20, 30], W = 50

// Output: 220

// Explanation: Select items with weights 20 and 30 for a total value of 100 + 120 = 220.

import java.util.Arrays;

public class Knapsack0and1 {
    static int[][] dp;

    public static void main(String[] args) {
        int[] val = { 60, 100, 120 };
        int[] wt = { 10, 20, 30 };
        int totalWeight = 50;
        dp = new int[val.length + 1][totalWeight + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        System.out.println("Max vals that can be obtained is " + recursion(0, wt, val, totalWeight));

    }

    private static int recursion(int index, int[] wt, int[] val, int totalWeight) {
        if (index == wt.length)
            return 0;
        if (dp[index][totalWeight] != -1)
            return dp[index][totalWeight];
        int pick = 0;
        if (wt[index] <= totalWeight) {
            pick = val[index] + recursion(index + 1, wt, val, totalWeight - wt[index]);
        }
        int noPick = 0 + recursion(index + 1, wt, val, totalWeight);
        dp[index][totalWeight] = Math.max(pick, noPick);
        return dp[index][totalWeight];
    }
}
// same pick and non pick algo
// before you pick check once can i take that weight, if yes pick that