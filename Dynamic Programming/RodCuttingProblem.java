// Given a rod of length N inches and an array price[] where price[i] 
// denotes the value of a piece of rod of length i inches (1-based indexing).
//  Determine the maximum value obtainable by cutting up the rod and selling 
// the pieces. Make any number of cuts, or none at all, and sell the resulting pieces.

import java.util.Arrays;

public class RodCuttingProblem {
    static int dp[][];

    public static void main(String[] args) {
        int[] price = { 1, 6, 8, 9, 10, 19, 7, 20 };
        int n = 8;
        dp = new int[price.length + 1][n + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        System.out.println("Maximum prices that can be obtained by cutting rods in : " + n + " index value are : "
                + recursion(0, price, n));
        System.out.println("Maximum prices that can be obtained by cutting rods in : " + n + " index value are : "
                + tabulation(price, n));
    }

    private static int recursion(int index, int[] price, int target) {
        if (index == price.length)
            return 0;
        if (dp[index][target] != -1)
            return dp[index][target];
        int noPick = recursion(index + 1, price, target);
        int pick = 0;
        if (target >= index + 1) {
            pick = price[index] + recursion(index, price, target - (index + 1));
        }
        dp[index][target] = Math.max(pick, noPick);
        return dp[index][target];
    }

    public static int tabulation(int price[], int n) {
        int dp[][] = new int[price.length + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = price[0] * i;
        }
        for (int len = 2; len <= price.length; len++) {
            for (int target = 1; target <= n; target++) {
                int noPick = dp[len - 1][target];
                int pick = 0;
                if (target >= len) {
                    pick = price[len - 1] + dp[len][target - len];
                }
                dp[len][target] = Math.max(pick, noPick);
            }
        }
        return dp[dp.length - 1][n];
    }
}
// same pick and no pick algo
// since we need to consider index from 1-> n whenever we choose index make sure
// we decrement the target as target - (index + 1) not target - index

// tabulation, since the question is for 1 based indexing, so add base case for
// index 1, then extend dp upto <=n