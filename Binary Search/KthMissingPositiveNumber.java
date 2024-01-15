public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 5, 7, 9 };
        int k = 3;
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(arr, k);
        System.out.println("Brute Force : " + bruteForce);
        int binarySearch = solution.binarySearch(arr, k);
        System.out.println("Binary Search : " + binarySearch);
    }

    private static class Solution {
        private int bruteForce(int[] arr, int k) {
            // for an empty array the mising 3 value is 3 , so for array containg sorted
            // values if the elem is less than k increase the k value until k is less than
            // elem and that elem is the missing one
            for (int ele : arr) {
                if (ele <= k) {
                    k++;
                } else {
                    break;
                }
            }
            return k;
        }
        private int binarySearch(int arr[], int k) {
            int low = 0, high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                // considering 1 should conatin 1 , 2->2,3->3...in same we will check if in
                // 5-> 8 then 8 - 5 = 3 is the missing numbers
                int missNumbers = arr[mid] - (mid + 1);
                if (missNumbers < k)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return low + k;
        }
    }
}
