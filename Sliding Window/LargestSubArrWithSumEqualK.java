//we should find the SunArray with less than or equals k
public class LargestSubArrWithSumEqualK {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = { 2, 5, 1, 7, 1, 10, 4 };
        int k = 14;
        int bruteForce = solution.getBruteForce(arr, k);
        System.out.println("Brute Force Largest Sub Array length with sum less than or equal to k : " + bruteForce);
        int betterApproach = solution.getBetterApproach(arr, k);
        System.out.println("Better Approach Largest Sub Array length with sum less than or equal to k : " + betterApproach);
        int optimalApproach = solution.getOptimalApproach(arr, k);
        System.out.println("Optimal Approach Largest Sub Array length with sum less than or equal to k : " + optimalApproach);

    }

    private static class Solution {
        private int getBruteForce(int arr[], int k) {
            int maxLen = 0;
            for (int i = 0; i < arr.length; i++) {
                int sum = 0;
                for (int j = i; j < arr.length; j++) {
                    sum = sum + arr[j];
                    if (sum <= k) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    } else {
                        break;
                    }
                }
            }
            return maxLen;
        }

        private int getBetterApproach(int arr[], int k) {
            int left = 0;
            int right = 0;
            int maxLen = 0;
            int sum = 0;
            while (right < arr.length) {
                sum = sum + arr[right];
                while (sum > k) {
                    sum = sum - arr[left];
                    left = left + 1;
                }
                if (sum <= k) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
                right = right + 1;
            }
            return maxLen;
        }

        private int getOptimalApproach(int arr[], int k) {
            int left = 0;
            int right = 0;
            int maxLen = 0;
            int sum = 0;
            while (right < arr.length) {
                sum = sum + arr[right];
                if (sum > k) {
                    sum = sum - arr[left];
                    left = left + 1;
                }
                if (sum <= k) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
                right = right + 1;
            }
            return maxLen;
        }
    }
}
// the diiference in better and optimal is that in the betterApproach , we take
// pointers left and right, then we keep addding elements to right, the moment
// the sum goes above k, the we shrink the left values, we shrink left values
// untill the sum = sum - arr[left] is less than k

// in the optimal approach, we are using the intituion, that is we already have
// the largest from (right - left + 1), so we are finding the maximum sub array
// length,so don't shrink everything, shrink once and and increment the right,
// becuase if we keep shrinking the left values, the length of sub array will
// keep reducing, we need maximum subarray length.