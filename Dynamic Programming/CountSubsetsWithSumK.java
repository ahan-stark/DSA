// Given an array arr of n integers and an integer K, count the number of subsets of the given array 
// that have a sum equal to K. Return the result modulo (109 + 7).
// Input: arr = [2, 3, 5, 16, 8, 10], K = 10

// Output: 3

// Explanation: The subsets are [2, 8], [10], and [2, 3, 5].

import java.util.Arrays;

public class CountSubsetsWithSumK {
    static int dp[][];

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 16, 8, 10 };
        int k = 10;
        dp = new int[arr.length][k + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        System.out.println("Total subsets with sum = " + k + " are : " + recursion(arr, k, 0));
        System.out.println("Total subsets with sum = " + k + " are : " + tabulation(arr, k));
    }

    private static int recursion(int[] arr, int k, int curIndex) {
        if (k == 0)
            return 1;
        if (k < 0)
            return 0;
        if (curIndex >= arr.length)
            return 0;
        if (dp[curIndex][k] != -1)
            return dp[curIndex][k];
        int pick = recursion(arr, k - arr[curIndex], curIndex + 1);
        int noPick = recursion(arr, k, curIndex + 1);
        dp[curIndex][k] = (int) ((pick + noPick) % (1e9 + 7));
        return dp[curIndex][k];
    }

    private static int tabulation(int[] arr, int K) {
        int MODULO = 10000000;
        int n = arr.length;
        int[][] dp = new int[n][K + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= K) {
            dp[0][arr[0]] = 1;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= K; target++) {
                int notTaken = dp[ind - 1][target];
                int taken = 0;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]] % MODULO;
                }
                dp[ind][target] = (notTaken + taken) % MODULO;
            }
        }
        return dp[n - 1][K];
    }
}
