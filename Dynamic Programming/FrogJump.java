// A frog wants to climb a staircase with n steps. Given an integer array heights, 
//where heights[i] contains the height of the ith step.
// To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, 
// where abs() denotes the absolute difference. The frog can jump from any step either one or two steps, 
// provided it exists. Return the minimum amount of energy required by the frog to 
// go from the 0th step to the (n-1)th step.
// Input: heights = [2, 1, 3, 5, 4]

// Output: 2

// Explanation: One possible route can be,

// 0th step -> 2nd Step = abs(2 - 3) = 1

// 2nd step -> 4th step = abs(3 - 4) = 1

// Total = 1 + 1 = 2.

import java.util.Arrays;

public class FrogJump {

    public static void main(String[] args) {
        int[] heights = { 2, 1, 3, 5, 4 };
        int[] dp = new int[heights.length + 1];
        Arrays.fill(dp, -1);
        System.out.println("Minimum amount of energy from 1  to " + heights.length + " is  : "
                + recursion(heights.length - 1, heights, dp));
    }

    private static int recursion(int n, int[] heights, int[] dp) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int right = Integer.MAX_VALUE;
        int left = recursion(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        if (n - 2 >= 0) {
            right = recursion(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        }
        dp[n] = Math.min(left, right);
        return dp[n];

    }
}