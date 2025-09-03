// Given an array nums of n integers and an integer target, build an expression using 
// the integers from nums where each integer can be prefixed with either a '+' or '-' sign.

// The goal is to achieve the target sum by evaluating all possible combinations of these signs.
//we should consider all the elems

import java.util.Arrays;

public class TargetSum {
    static int[][] dp;
    static int sum = 0;

    public static void main(String[] args) {
        int[] nums = { 1, 2, 7, 1, 5 };
        int target = 4;
        for (int ele : nums)
            sum = sum + ele;
        dp = new int[nums.length + 1][(sum * 2) + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        System.out.println("Total ways to achieve sum = " + target + " : " + recursion(0, nums, target));
    }

    private static int recursion(int index, int[] nums, int target) {
        if (target > sum || target < -sum)
            return 0;
        if (index == nums.length)
            return target == 0 ? 1 : 0;
        if (dp[index][target + sum] != -1)
            return dp[index][target + sum];
        int pos = recursion(index + 1, nums, target + nums[index]);
        int neg = recursion(index + 1, nums, target - nums[index]);
        dp[index][target + sum] = pos + neg;
        return dp[index][target + sum];
    }
}
// when memoizing we might get neg val that is target, so when we create the dp,
// calculate the totalSum and make space as 2 * sum + 1
// 0 -> sum : neg val
// sum + 1 -> 2 * sum : pos val
// for each index, do pos and neg
// we should consider all the elems, so check after all the index for base class