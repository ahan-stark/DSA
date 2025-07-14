// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Total ways to climb is " + recursion(n, dp) + " times");
    }

    private static int recursion(int n, int[] dp) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        int left = recursion(n - 1, dp);
        int right = recursion(n - 2, dp);
        dp[n] = left + right;
        return dp[n];
    }
}
