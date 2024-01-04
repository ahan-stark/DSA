// Lower Bound is the lowest element matching arr[i] > lowerBound
public class UpperBound {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 5, 6, 8, 12, 14 };
        int upperBound = 3;
        Solution solution = new Solution();
        int sol = solution.sol(arr, upperBound);
        System.out.println("uppper Bound : " + sol);
    }

    private static class Solution {
        private int sol(int arr[], int upperBound) {
            int low = 0, high = arr.length - 1;
            // assume answer is not present
            int ans = arr.length;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] > upperBound) {
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
