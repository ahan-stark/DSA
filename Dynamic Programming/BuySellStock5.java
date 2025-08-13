import java.util.Arrays;

// Given an array arr where arr[i] represents the price of a given stock on the ith day. 
// Additionally, you are given an integer fee representing a transaction fee for each trade. 
// The task is to determine the maximum profit you can achieve such that you need to pay a 
// transaction fee for each buy and sell transaction. The Transaction Fee is applied when you sell a stock.

// You may complete as many transactions. You may not engage in multiple transactions simultaneously
//  (i.e., you must sell the stock before buying again).

// Input: arr = [1, 3, 2, 8, 4, 9], fee = 2

// Output: 8

// Explanation: Buy at day 1 (price = 1), sell at day 4 (price = 8), 
// then Buy at day 5 (price = 4), sell at day 6 (price = 9),

// Profit calculation: ((9 - 4) - 2) + ((8 - 1) - 2)= 8.



public class BuySellStock5 {
    static int[][] dp;

    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        dp = new int[prices.length + 1][2];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        System.out.println("Max profit we can get by paying transaction fee is " + recursion(0, 1, prices, fee));
    }
    private static int recursion(int index, int canBuy, int[] arr, int fee) {
    if (index == arr.length) return 0;
    if (dp[index][canBuy] != -1) return dp[index][canBuy];
    int profit = 0;
    if (canBuy == 1) {
      // buy case
            int buyNow = -arr[index] + recursion(index + 1, 0, arr, fee);;
            int skipBuy = recursion(index + 1, 1, arr, fee);
            profit = Math.max(buyNow, skipBuy);
    } else {
      // sale case
      int sellNow = arr[index] - fee + recursion(index + 1, 1, arr, fee);
      int skipSell = recursion(index + 1, 0, arr, fee);
      profit = Math.max(sellNow, skipSell);
    }
    dp[index][canBuy] = profit;
    return dp[index][canBuy];
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
//when selling minus the transaction fees