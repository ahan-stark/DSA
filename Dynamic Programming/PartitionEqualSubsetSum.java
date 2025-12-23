// Given an integer array nums, return true if you can partition the array into two 
// subsets such that the sum of the elements in both subsets is equal or false otherwise.
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static int dp[][];

    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5 };
        int sum = 0;
        for (int ele : nums) {
            sum = sum + ele;
        }
        if (sum % 2 != 0)
            System.out.println("Cannot split!");
        int target = sum / 2;
        dp = new int[nums.length][target + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        System.out.println("Possible to split ? : " + recursion(nums, target, nums.length - 1));
        System.out.println("Possible to split ? : " + tabulation(nums));
    }

    private static boolean recursion(int[] nums, int target, int index) {
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        if (index < 0)
            return false;
        if (dp[index][target] != -1)
            return dp[index][target] == 1 ? true : false;
        boolean choose = recursion(nums, target - nums[index], index - 1);
        boolean skip = recursion(nums, target, index - 1);
        dp[index][target] = choose == true || skip == true ? 1 : 0;
        return dp[index][target] == 1 ? true : false;
    }

    private static boolean tabulation(int arr[]) {
        int val = 0;
        for (int ele : arr) {
            val = val + ele;
        }
        if (val % 2 != 0)
            return false;
        int target = val / 2;
        boolean dp[][] = new boolean[arr.length + 1][target + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        if (target >= arr[0]) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int tar = 1; tar <= target; tar++) {
                boolean noPick = dp[i - 1][tar];
                boolean pick = false;
                if (tar - arr[i] >= 0) {
                    pick = dp[i - 1][tar - arr[i]];
                }
                dp[i][tar] = pick == true ? true : noPick;
            }
        }
        return dp[arr.length - 1][target];
    }
}
// since we need 2 subarry with equal sum, we first add all the value
// then check if the total sum is odd, if it is odd we cannot partition equally
// lets say we got 23 we cannot split it equally so return false
// if we get 24 -> we need 12 in one and 12 in second
// so we keep target as 12 and check can we reach 12
// when we choose we say we reduce the target and base case is target == 0
// do dp for index and that particular target