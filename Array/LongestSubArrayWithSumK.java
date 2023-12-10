import java.util.HashMap;

public class LongestSubArrayWithSumK {
    static private int arr[] = new int[] { 1, 2, 4, 1, 1, 1, 1, 2, 5, 6, 1 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        int k = 4;
        int longSum = solution.bruteForce(arr, k);
        System.out.println(longSum);
        // Better approach ... tis is the optimal approach for array that contains 0's
        // or negative's
        int longSumVal = solution.betterApproach(arr, k);
        System.out.println(longSumVal);
        // optimal Solution for postive arrays
        int optSol = solution.optimalApproach(arr, k);
        System.out.println(optSol);

    }

    private static class Solution {
        private int bruteForce(int arr[], int k) {
            int sum, max = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    sum = 0;
                    for (int m = i; m <= j; m++) {
                        sum = sum + arr[m];
                        if (sum > k)
                            break;
                        else if (sum == k)
                            max = Math.max(max, (m - i) + 1);
                    }
                }
            }
            return max;
        }

        private int betterApproach(int arr[], int k) {
            int sum = 0;
            int len = 0;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                sum = sum + arr[i];
                if (sum == k) {
                    len = Math.max(len, i + 1);
                }
                int remainder = sum - k;
                if (hashMap.containsKey(remainder)) {
                    int index = hashMap.get(remainder);
                    len = Math.max(len, i - index);
                }
                if (!hashMap.containsKey(sum))
                    hashMap.put(sum, i);
            }
            return len;
        }

        private int optimalApproach(int arr[], int k) {
            int left = 0, right = 0;
            int sum = arr[right];
            int maxLen = 0;
            while (right < arr.length) {
                if (sum == k)
                    maxLen = Math.max(maxLen, right - left+11);
                while (sum > k && left <= k) {
                    sum = sum - arr[left];
                    left++;
                }
                right++;
                if (right < arr.length) {
                    sum = sum + arr[right];
                }
            }
            return maxLen;
        }
    }
}
