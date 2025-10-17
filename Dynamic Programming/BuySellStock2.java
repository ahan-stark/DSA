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
        System.out.println("Max profit achiveable is :  " + tabulation(arr));
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

    private static int tabulation(int arr[]) {
        // 1 -> buy case, 2 -> sell case
        int dp[][] = new int[arr.length + 1][2];
        dp[dp.length - 1][0] = 0;
        dp[dp.length - 1][1] = 0;
        int profit = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 0) {
                    // sell case
                    int sell = arr[i] + dp[i +  1][1];
                    int skipSell = 0 + dp[i + 1][0];
                    profit = Math.max(sell, skipSell);
                } else {
                    // buy case
                    int buyNow = -arr[i] + dp[i + 1][0];
                    int skipBuy = 0 + dp[i + 1][1];
                    profit = Math.max(buyNow, skipBuy);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
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