// Given an integer array ‘A’ of size ‘N’ and an integer ‘K’. Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized. Your task is to return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

public class SplitArray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int subArrays = 3;
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(arr, subArrays);
        System.out.println("Brute Force : " + bruteForce);
        int binarySearch = solution.binarySearch(arr, subArrays);
        System.out.println("Binary Search : " + binarySearch);
    }

    private static class Solution {
        private int bruteForce(int arr[], int subArrays) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            // we know to allocate subArrays , we have to able to have capcity of min the
            // max of arr, so we keep max as sum of arr
            for (int ele : arr) {
                sum = sum + ele;
                max = Math.max(max, ele);
            }
            // i will consider max and say the subArr can contain i val, if it exceeds than
            // it will be new sub array
            for (int i = max; i <= sum; i++) {
                if (getNumberOfSplits(arr, i) == subArrays)
                    return i;
            }
            return max;
        }

        private int binarySearch(int arr[], int subArrays) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int ele : arr) {
                sum = sum + ele;
                max = Math.max(max, ele);
            }
            int low = max, high = sum;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (getNumberOfSplits(arr, mid) <= subArrays) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private int getNumberOfSplits(int arr[], int totalVal) {
            int sum = 0;
            int subarray = 1;
            for (int i = 0; i < arr.length; i++) {
                if (sum + arr[i] <= totalVal) {
                    // if the sum + arr[i] is less than totalCapacity that means that it can be fit
                    // in one array else increase the subArray count and assign the new val to it
                    sum = sum + arr[i];
                } else {
                    sum = arr[i];
                    subarray++;
                }
            }
            return subarray;
        }
    }
}
