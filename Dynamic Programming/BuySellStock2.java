// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share
// of the stock at any time. However, you can buy it then immediately sell it on the same day.

// Find and return the maximum profit you can achieve.

// Input: prices = [7,1,5,3,6,4]
// Output: 7
// Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
// Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
// Total profit is 4 + 3 = 7.

import java.util.Arrays;

public class BuySellStock2 {
    static int[][] dp;

    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        dp = new int[arr.length][2];
        for (int[] temp : dp)
            Arrays.fill(temp, -1);
        System.out.println("Max profit achiveable is :  " + recursion(0, 1, arr));
    }

    private static int recursion(int index, int buy, int[] prices) {
        if (index == prices.length)
            return 0;
        if (dp[index][buy] != -1)
            return dp[index][buy];
        int profit = 0;
        if (buy == 1) {
            // buy case
            int buyNow = -prices[index] + recursion(index + 1, 0, prices);
            int skipBuy = 0 + recursion(index + 1, 1, prices);
            profit = Math.max(buyNow, skipBuy);
        } else {
            // sell case
            int sellNow = prices[index] + recursion(index + 1, 1, prices);
            int skipSell = 0 + recursion(index + 1, 0, prices);
            profit = Math.max(sellNow, skipSell);
        }
        dp[index][buy] = Math.max(0, profit);
        return dp[index][buy];
    }
}
//keep buy 1 and sell 0
//maintain dp with index and buy or sell states
//initailly keep 1 becuase we need to buy first
// keep scenario for buying and selling
// for each buy or sell
// keep the values like if i sell now or sell next
// profit in buying is like adding -curEle + findRecusrion(sell)
// selling profit is like add curEle + findRecursion(buy)
// when buying we are actually going money down so decrement that much, then for
// that add sellValue
// buy -> 3 , sell -> 8
// -3 + 8 = 5