// Given an integer array nums, find the number of Longest Increasing Subsequences (LIS) in the array.
// nput: nums = [1, 3, 5, 4, 7]

// Output: 2

// Explanation: There are two LIS of length 4:

// [1, 3, 4, 7]

// [1, 3, 5, 7].

// nput: nums = [2, 2, 2, 2, 2]

// Output: 5

// Explanation: All elements are the same, so every single element can form an LIS of length 1. There are 5 such subsequences.

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequences {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 4, 7 };
        System.out.println("NumberOfLongestIncreasingSubsequences : " + numberOfLIS(arr));
    }

    private static int numberOfLIS(int[] nums) {
        int count[] = new int[nums.length];
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLen = 1;
        for (int curIndex = 1; curIndex < nums.length; curIndex++) {
            for (int prevIndex = 0; prevIndex < curIndex; prevIndex++) {
                if (nums[curIndex] > nums[prevIndex]) {
                    if (dp[prevIndex] + 1 > dp[curIndex]) {
                        // found new longer length, inherit count from prevIndex
                        dp[curIndex] = 1 + dp[prevIndex];
                        count[curIndex] = count[prevIndex];
                    } else if (dp[prevIndex] + 1 == dp[curIndex]) {
                        // if we find the same length again
                        // for the exsisting count, add new one
                        count[curIndex] = count[curIndex] + count[prevIndex];
                    }
                }
            }
            if (dp[curIndex] > maxLen) {
                maxLen = dp[curIndex];
            }
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLen) {
                ans = ans + count[i];
            }
        }
        return ans;
    }
}
// we need to find the total count of LIS, so with a dp array, have a count
// array to store the maxCount for maxLIS for that index. If we get new value,
// or new LIS, inherit the count from prevIndex, if we get equal, add prevCount
// to the exsisting count.

// [1, 3, 5, 4, 7] -> 1,3,5 => LIS = 3, count = 1 , 1,3,4 => LIS = 3, count = 1,
// when taking 7 for 5, we inherit 1 and count = 1, meaning length = 4 cnt = 1
// For 4, we get equal length (i.e, 4), so add prevIndex count (i.e, 1 in this
// case) to it again. Meaning when we added first time, we made a new subseq
// 1,3,5,7 => count = 1, next when we get 1,3,4,7 add this to total count with
// prevIndex, making total count = 2
// Once we get logic, that is each count array is stored with LIS upto that
// index, keep the val of maxLen. At the end, go and check which dp[i] has that
// maxLen, if we get, add that to count[i] to the total
