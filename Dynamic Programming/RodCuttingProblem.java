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
}
// same pick and no pick algo
// since we need to consider index from 1-> n whenever we choose index make sure
// we decrement the target as target - (index + 1) not target - index