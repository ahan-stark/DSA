public class SearchInSorted2dMatrix {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        int target = 8;
        Solution solution = new Solution();
        boolean bruteForce = solution.bruteForce(arr, target);
        System.out.println("Target found in matrix : " + bruteForce);
        boolean betterApproach = solution.betterApproach(arr, target);
        System.out.println("Target found in matrix : " + betterApproach);
        boolean binarySearch = solution.binarysearch(arr, target);
        System.out.println("Target found in matrix : " + binarySearch);

    }

    private static class Solution {
        private boolean bruteForce(int arr[][], int target) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == target)
                        return true;
                }
            }
            return false;
        }

        private boolean betterApproach(int arr[][], int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] <= target && arr[i][arr[0].length - 1] >= target) {
                    return checkTarget(arr[i], target) ? true : false;
                }
            }
            return false;
        }

        private boolean checkTarget(int arr[], int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target)
                    return true;
            }
            return false;
        }

        private boolean binarysearch(int arr[][], int target) {
            // we do think 2d arr as 1d arr, we say [0][0],[0][1]....as 0,1
            int low = 0;
            int high = ((arr.length) * arr[0].length) - 1;
            while (low <= high) {
                // we get [0][0] or [0][3] row we will get as num / arr[0].length,
                // col as num % arr[0].length
                int mid = (low + high) / 2;
                int row = mid / arr[0].length;
                int col = mid % arr[0].length;
                if (arr[row][col] == target)
                    return true;
                if (arr[row][col] <= target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return false;
        }
    }
}
