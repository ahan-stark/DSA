public class BSuponRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        int target = 8;
        Solution solution = new Solution();
        int pos = solution.optimalSol(arr, target);
        System.out.println("Element exsists at : " + pos);

    }

    private static class Solution {
        private int optimalSol(int arr[], int target) {
            int low = 0, high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target)
                    return mid;
                // check which part of the array is sorted, either its left half ot right half
                // under this case left half is sorted
                if (arr[low] <= arr[mid]) {
                    if (arr[low] <= target && target <= arr[mid])
                        high = mid - 1;
                    else
                        low = mid + 1;
                }
                // under this case right half is sorted
                else if (arr[mid] <= arr[high]) {
                    if (arr[mid] <= target && target <= arr[high])
                        low = mid + 1;
                    else
                        high = mid - 1;

                }
            }
            return -1;
        }

    }
}
