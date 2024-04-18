// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 1, 1 };
        int k = 3;
        Solution solution = new Solution();
        int totalSubArr = solution.getTotalSubArr(arr, k);
        System.out.println(totalSubArr);

    }

    private static class Solution {
        private int getTotalSubArr(int arr[], int k) {
            int totalSubArr = findTotalSubArr(arr, k) - findTotalSubArr(arr, k - 1);
            return totalSubArr;
        }

        private int findTotalSubArr(int arr[], int k) {
            if (k < 0)
                return 0;
            int count = 0;
            int sum = 0;
            int left = 0, right = 0;
            while (right < arr.length) {
                sum = sum + (arr[right] % 2);
                while (sum > k) {
                    sum = sum - (arr[left] % 2);
                    left = left + 1;
                }
                count = count + (right - left + 1);
                right = right + 1;
            }
            return count;
        }
    }

}
// this problem is similar to finding the binary subarr with sum = k, here we
// convert the odd to 1 and even to 0 such that we sum it up and check if its is
// equal to k that find(k) - find(k - 1)