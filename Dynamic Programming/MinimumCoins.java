// Given an integer array of coins representing coins of different denominations 
// and an integer amount representing a total amount of money. Return the fewest 
// number of coins that are needed to make up that amount. If that amount of money 
// cannot be made up by any combination of the coins, return -1. There are infinite 
// numbers of coins of each type
// Input: coins = [1, 2, 5], amount = 11

// Output: 3

// Explanation: 11 = 5 + 5 + 1. We need 3 coins to make up the amount 11.

import java.util.Arrays;

public class MinimumCoins {
    static int[][] dp;

    public static void main(String[] args) {
        int coins[] = { 1, 2, 5 };
        int amount = 11;
        dp = new int[coins.length][amount + 1];
        for (int[] temp : dp)
            Arrays.fill(temp, -1);
        int ans = recursion(0, coins, amount);
        System.out.println("Minimum coins : " + (ans != Integer.MAX_VALUE ? ans : -1));
        System.out.println("Minimum coins : " + tabulation(coins, amount));
    }

    private static int recursion(int index, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (index == coins.length)
            return Integer.MAX_VALUE;
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (dp[index][amount] != -1)
            return dp[index][amount];
        int pick = recursion(index, coins, amount - coins[index]);
        int pickVal = Integer.MAX_VALUE;
        if (pick != Integer.MAX_VALUE)
            pickVal = 1 + pick;
        int skip = recursion(index + 1, coins, amount);
        dp[index][amount] = Math.min(pickVal, skip);
        return dp[index][amount];
    }

    private static int tabulation(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? i / coins[0] : (int) 1e9;
        }
        for (int index = 1; index < coins.length; index++) {
            for (int amt = 0; amt <= amount; amt++) {
                int noPick = dp[index - 1][amt];
                int pick = (int) 1e9;
                if (coins[index] <= amt) {
                    pick = 1 + dp[index][amt - coins[index]];
                }
                dp[index][amt] = Math.min(pick, noPick);
            }
        }
        int ans = dp[dp.length - 1][dp[0].length - 1];
        return ans != (int) 1e9 ? ans : -1;
    }
}
// use pick and non pick algo
// if we pick, try to pick again or skip

// In tabulation since we pick same elem multiple times, so in pick logic dont
// check prevIndex, check the cur one.
// if we have total 11, if we are in target loop 10, if we pick curr elem that
// is 5, add one, meaning picked one then get dp[index][10-5], same index 5th
// state(target), because we are picking 2 times one in 5th state, one more in
// 10th state.
// this logic is applicable if we can pick from same index, multiple times