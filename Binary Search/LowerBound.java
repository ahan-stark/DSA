// Lower Bound is the lowest element matching arr[i] >= lowerBound
public class LowerBound {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 5, 6, 8, 12, 14 };
        int lowerBound = 7;
        Solution solution = new Solution();
        int bruteForceSol = solution.bruteForce(arr, lowerBound);
        System.out.println("Brute Force Approach : " + bruteForceSol);
    }

    private static class Solution {
        private int bruteForce(int arr[], int lowerBound) {
            int low = 0, high = arr.length - 1;
            // assume answer is not present
            int ans = arr.length;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] >= lowerBound) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }

    }
}
