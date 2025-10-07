import java.util.Arrays;

public class FrogJump2 {
    public static void main(String[] args) {
        int[] heights = { 10, 5, 20, 0, 15 };
        int k = 2;
        int[] dp = new int[heights.length + 1];
        Arrays.fill(dp, -1);
        System.out.println("Minimum amount of energy from 1  to " + heights.length + " is  : "
                + recursion(heights.length - 1, heights, k, dp));
        System.out.println("Minimum amount of energy from 1 to " + heights.length + " is : "
                + tabulation(heights, k));
    }

    private static int recursion(int n, int[] heights, int k, int[] dp) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int val = min;
            if (n - i >= 0)
                val = recursion(n - i, heights, k, dp) + Math.abs(heights[n] - heights[n - i]);
            min = Math.min(min, val);
        }
        dp[n] = min;
        return dp[n];
    }

    private static int tabulation(int[] heights, int k) {
        int dp[] = new int[heights.length];
        for (int i = 1; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                int val = Math.abs(heights[i] - heights[j]) + dp[j];
                min = Math.min(min, val);
            }
            dp[i] = min;
        }
        return dp[dp.length - 1];
    }
}
