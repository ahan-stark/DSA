// Given an array arr of n integers, the task is to find the length of the longest bitonic sequence. 
// A sequence is considered bitonic if it first increases, then decreases. 
// The sequence does not have to be contiguous.
// Input: arr = [5, 1, 4, 2, 3, 6, 8, 7]

// Output: 6

// Explanation: The longest bitonic sequence is [1, 2, 3, 6, 8, 7] with length 6.

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 4, 2, 3, 6, 8, 7 };
        System.out.println("longestBitonicSequence : " + longestBitonicSequence(arr));
    }

    public static int longestBitonicSequence(int[] arr) {
        int dp1[] = new int[arr.length];
        int dp2[] = new int[arr.length];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int curIndex = 1; curIndex < arr.length; curIndex++) {
            for (int prevIndex = 0; prevIndex < curIndex; prevIndex++) {
                if (arr[curIndex] > arr[prevIndex] && dp1[prevIndex] + 1 > dp1[curIndex]) {
                    dp1[curIndex] = dp1[prevIndex] + 1;
                }
            }
        }
        for (int curIndex = arr.length - 2; curIndex >= 0; curIndex--) {
            for (int prevIndex = arr.length - 1; prevIndex > curIndex; prevIndex--) {
                if (arr[curIndex] > arr[prevIndex] && dp2[prevIndex] + 1 > dp2[curIndex]) {
                    dp2[curIndex] = dp2[prevIndex] + 1;
                }
            }
        }
        int maxVal = 1;
        for (int i = 0; i < dp1.length; i++) {
            if ((dp1[i] + dp2[i]) - 1 > maxVal) {
                maxVal = (dp1[i] + dp2[i]) - 1;
            }
        }
        return maxVal;
    }
}
// The logic is keep 2 dp array, calculating highest increased order from left
// to right and also from right to left.
// After that, each point check what is increasing number of total points from
// left to that point using dp1 and same way from right to that point from dp2
// that is the total value, in the answer, -1 the value as we calculate the same
// point from both the directions
// for [5, 1, 4, 2, 3, 6, 8, 7] -> [1,2,3,6,8,7]
// in the index 4, the increasing numbers will be 5 from left and increasing
// numbers will 2 from arr.length - 1,
// therefore 5 + 2 = 7, remove -1 as we added 8 in both the times.