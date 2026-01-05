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
        System.out.println("Max vals that can be obtained is " + tabulation(wt, val, totalWeight));

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

    private static int tabulation(int[] wt, int[] val, int W) {
        int dp[][] = new int[wt.length][W + 1];
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }
        for (int i = 1; i < val.length; i++) {
            for (int weight = 1; weight <= W; weight++) {
                int noPick = dp[i - 1][weight];
                int pick = 0;
                if (wt[i] <= weight) {
                    pick = val[i] + dp[i - 1][weight - wt[i]];
                }
                dp[i][weight] = Math.max(pick, noPick);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
// same pick and non pick algo
// before you pick check once can i take that weight, if yes pick that

// tabulation
// We start assigning the initial dp with values of "wt" that can be choosen,
// for wt[0] which ever is greater than or equal to that, we put the first
// value, meaning when we are in index 2 and 'wt' we try to access, the weight
// should be greater than or equal to allowed weight for first one
// if first wt is 4, only the wt 4 or above can access the value from that
// index, else it cannot access, meaning the value will be 0