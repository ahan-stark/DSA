public class StockBuySell {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        int profit = solution.findProfit(prices);
        System.out.println("Max profit from stock is :" + profit);
    }

    private static class Solution {
        private int findProfit(int prices[]) {
            int profit = 0;
            int buyDay = prices[0];
            for (int i = 1; i < prices.length; i++) {
                profit = Math.max(prices[i] - buyDay, profit);
                buyDay = Math.min(prices[i], buyDay);
            }
            return profit;
        }

    }
}