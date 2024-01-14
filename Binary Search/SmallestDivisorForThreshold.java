public class SmallestDivisorForThreshold {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int threshold = 8;
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(arr, threshold);
        System.out.println("Brute Force : " + bruteForce);
        int binarySearch = solution.binarySearch(arr, threshold);
        System.out.println("Binary Search : " + binarySearch);
    }

    private static class Solution {
        public int bruteForce(int[] arr, int threshold) {
            int max = Integer.MIN_VALUE;
            for (int ele : arr) {
                max = Math.max(ele, max);
            }
            int ans = max;
            for (int i = 1; i <= max; i++) {
                if (checkDividing(arr, i) <= threshold) {
                    return i;
                }
            }
            return ans;
        }

        private int binarySearch(int arr[], int threshold) {
            int max = Integer.MIN_VALUE;
            for (int ele : arr) {
                max = Math.max(ele, max);
            }
            int low = 1;
            int high = max;
            int ans = max;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (checkDividing(arr, mid) <= threshold) {
                    ans = Math.min(ans, mid);
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }
        private int checkDividing(int[] arr, int divisor) {
            int ans = 0;
            for (int ele : arr) {
                ans += Math.ceil((double) (ele) / (double) divisor);
            }
            return ans;
        }
    }
}
