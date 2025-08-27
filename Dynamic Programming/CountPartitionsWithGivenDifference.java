// Given an array arr of n integers and an integer diff, count the number of ways
//  to partition the array into two subsets S1 and S2 such that:

// ∣S1−S2∣ = diff and S1 ≥ S2
// Where |S1| and |S2| are sum of Subsets S1 and S2 respectively.

// Return the result modulo 109 + 7.
// Input: arr = [1, 1, 2, 3], diff = 1

// Output: 3

// Explanation: The subsets are [1, 2] and [1, 3], [1, 3] and [1, 2], [1, 1, 2] and [3].

import java.util.Arrays;

public class CountPartitionsWithGivenDifference {
    static int dp[][];

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3 };
        int diff = 1;
        System.out.println("Total subsets  : " + findSubsets(arr, diff));
    }

    private static int findSubsets(int[] arr, int diff) {
        int sum = 0;
        for (int ele : arr) {
            sum = sum + ele;
        }
        if (sum - diff <= 0)
            return 0;
        if (sum - diff == 1)
            return 0;
        if ((sum - diff) % 2 != 0)
            return 0;
        int target = (sum - diff) / 2;
        dp = new int[arr.length][target + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        return recursion(0, target, arr, dp);
    }

    private static int recursion(int index, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return 1;
        if (target < 0 || index == arr.length)
            return 0;
        if (dp[index][target] != -1)
            return dp[index][target];
        int pick = recursion(index + 1, target - arr[index], arr, dp);
        int noPick = recursion(index + 1, target, arr, dp);
        dp[index][target] = (pick + noPick) % ((int) 1e9 + 7);
        return dp[index][target];
    }
}
// this problem is same as finding the target sum
// since we need ∣S1−S2∣ = diff and S1 ≥ S2
// we need to find the target
// lets say we have arr = [1, 1, 2, 3], diff = 1
// totalSum = 7, 2 values should that is totalSum be 4 and 3 which gives diff 1
// so we think like totalSum = 7, minus the diff => 7 - 1 = 6, 6 / 2 => 3
// when we say sum - diff, we get target, that is s2, meaning the diff will be
// in s1
// it is like we eliminate diff from sum and divide by 2 to find if that val
// exists, that val as s2
// take out common diff and find the subset
// so target would be 3 that will be second value , i.e target = 3
// why not first value?
// first needs to be 4, as it is s1 > s2 and we get 3 in target, so we say
// target, i.e s2 = 3
// initial conditions : sum - diff < 0 || sum - diff < 1 return 0 , it should be
// 2 or more because we divide by 2, as we need to partitions

// since we need min diff to be 1, we get that by adding the min diff to s1,
// that is totalSum - diff will eliminate that extra from s2, then find the
// exact half
// Base conditions if sum - diff <= 0, sum - diff == 1, we need more than 1 as
// we divide in 2 parts.
// and an even number to divide and find the half