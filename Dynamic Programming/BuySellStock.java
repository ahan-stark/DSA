public class BuySellStock {
    public static void main(String[] args) {
        int arr[] = { 10, 7, 5, 8, 11, 9 };
        System.out.println("Max profit with best buy and best sell is : " + maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int buyDay = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(prices[i] - buyDay, profit);
            buyDay = Math.min(buyDay, prices[i]);
        }
        return profit;
    }
}
