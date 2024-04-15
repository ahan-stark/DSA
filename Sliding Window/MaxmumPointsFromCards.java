//you have to pick 4 cards in consecutive order either from left or right, or some from left and some from right, but it sgould be in consecutive order only, we have to find the max
public class MaxmumPointsFromCards {
    public static void main(String[] args) {
        int arr[] = { 6, 2, 3, 4, 7, 2, 1, 7, 1 };
        int k = 4;
        Solution solution = new Solution();
        int maxVal = solution.getMax(arr, k);
        System.out.println("Maximum Points in cards : " + maxVal);
    }

    private static class Solution {
        private int getMax(int arr[], int k) {
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0; i < k; i++) {
                leftSum = leftSum + arr[i];
            }
            int max = leftSum;
            int rightIndex = arr.length - 1;
            for (int i = k - 1; i >= 0; i--) {
                leftSum = leftSum - arr[i];
                rightSum = rightSum + arr[rightIndex];
                rightIndex = rightIndex - 1;
                max = Math.max(max, leftSum + rightSum);
            }
            return max;
        }
    }
}
// here first we loop till k index and get the leftsum, and consider it as the
// max, then we remove one indexed value from left part that is k-1 to 0 and
// keep adding cvalues from right index that is last element : arr.length - 1,
// this is how get the max value of consecutive elements
