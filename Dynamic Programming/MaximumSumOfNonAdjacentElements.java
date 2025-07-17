// Given an integer array nums of size n. Return the maximum sum possible using 
// the elements of nums such that no two elements taken are adjacent in nums.
// Input: nums = [2, 1, 4, 9]

// Output: 11

// Explanation: [2, 1, 4, 9], the underlined elements are taken to get the maximum sum.

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {
    private static int[] dp;

    public static void main(String[] args) {
        int nums[] = { 2, 1, 4, 9 };
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println("Maxiumum sum of non adjacent elements : " + recursion(nums.length - 1, nums));
    }

    private static int recursion(int num, int[] nums) {
        if (num == 0)
            return nums[0];
        if (num < 0)
            return 0;
        if (dp[num] != -1)
            return dp[num];
        int pick = nums[num] + recursion(num - 2, nums);
        int noPick = 0 + recursion(num - 1, nums);
        dp[num] = Math.max(pick, noPick);
        return dp[num];
    }
}
