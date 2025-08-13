// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete at most two transactions.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

import java.util.Arrays;

public class BuySellStock3 {
    static int[][][] dp;

    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        dp = new int[prices.length + 1][2][2];
        for (int i = 0; i < dp.length; i++) {
            for (int[] temp : dp[i]) {
                Arrays.fill(temp, -1);
            }
        }
        System.out.println("Max profit we can get by max 2 transaction is " + recursion(prices, 0, 1, 0));
    }

    private static int recursion(int[] arr, int index, int buy, int transaction) {
        if (transaction == 2)
            return 0;
        if (index == arr.length)
            return 0;
        if (dp[index][buy][transaction] != -1)
            return dp[index][buy][transaction];
        int profit = 0;
        if (buy == 1) {
            // buy case
            int buyNow = -arr[index] + recursion(arr, index + 1, 0, transaction);
            int skip = 0 + recursion(arr, index + 1, 1, transaction);
            profit = Math.max(buyNow, skip);
        } else {
            // sell case
            int sellNow = arr[index] + recursion(arr, index + 1, 1, transaction + 1);
            int skip = 0 + recursion(arr, index + 1, 0, transaction);
            profit = Math.max(sellNow, skip);
        }
        dp[index][buy][transaction] = profit;
        return dp[index][buy][transaction];
    }
}
// keep buy 1 and sell 0
// maintain dp with index and buy or sell states
// initailly keep 1 becuase we need to buy first
// keep scenario for buying and selling
// for each buy or sell
// keep the values like if i sell now or sell next
// profit in buying is like adding -curEle + findRecusrion(sell)
// selling profit is like add curEle + findRecursion(buy)
// when buying we are actually going money down so decrement that much, then for
// that add sellValue
// buy -> 3 , sell -> 8
// -3 + 8 = 5
// keep transaction count if its 2 you cannot perform more than this
// 3d dp to store index, then buy or sell inside that 0th transaction or 1st
// transaction