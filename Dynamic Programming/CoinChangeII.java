// Give an array coins of n integers representing coin denominations. 
// Your task is to find the number of distinct combinations that sum up
//  to a specified amount of money. If it's impossible to achieve the 
//  exact amount with any combination of coins, return 0.

// Single coin can be used any number of times.

// Return your answer with modulo 109+7.
// Input: coins = [2, 4,10], amount = 10

// Output: 4

// Explanation: The four combinations are:

// 10 = 10

// 10 = 4 + 4 + 2

// 10 = 4 + 2 + 2 + 2

// 10 = 2 + 2 + 2 + 2 + 2

import java.util.Arrays;

public class CoinChangeII {
    static int dp[][];

    public static void main(String[] args) {
        int[] coins = { 2, 4, 10 };
        int amount = 10;
        dp = new int[coins.length][amount + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        System.out.println("Total combinations : " + recursion(0, coins, amount));
        System.out.println("Total combinations : " + tabulation(coins, amount));

    }

    private static int recursion(int index, int[] coins, int amount) {
        if (amount == 0)
            return 1;
        if (amount < 0)
            return 0;
        if (index == coins.length)
            return 0;
        if (dp[index][amount] != -1)
            return dp[index][amount];
        int pickVal = recursion(index, coins, amount - coins[index]);
        int noPick = recursion(index + 1, coins, amount);
        dp[index][amount] = (pickVal + noPick) % ((int) 1e9 + 7);
        return dp[index][amount];
    }

    public static int tabulation(int[] coins, int amount) {
        int mod = (int) 1e9 + 7;
        int dp[][] = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0) {
                dp[0][amt] = 1;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int amt = 0; amt <= amount; amt++) {
                int noTake = dp[i - 1][amt];
                int take = 0;
                if (coins[i] <= amt) {
                    take = dp[i][amt - coins[i]];
                }
                dp[i][amt] = (take + noTake) % mod;
            }
        }
        return dp[dp.length - 1][amount];
    }
}
// one thing we observe is all values will be unique, if we start from the start
// index and try all possibilities as the coins are unique
// say we got 2 4 4, duplication happens if we get 4 4 2 or 4 2 4 since it is
// unique once we choose 2 we wont get that again