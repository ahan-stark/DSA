public class SearchElementinRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = { 3, 3, 2, 3, 3, 3, 3 };
        int target = 2;
        Solution solution = new Solution();
        // brute force - linear search
        boolean bruteForce = solution.bruteForce(arr, target);
        System.out.println("Brute Force : " + bruteForce);
        // binary search approach
        boolean binaryS = solution.binarySearch(arr, target);
        System.out.println("Binary Search : " + binaryS);
    }

    private static class Solution {
        private boolean bruteForce(int arr[], int target) {
            for (int elem : arr) {
                if (elem == target) {
                    return true;
                }
            }
            return false;
        }

        private boolean binarySearch(int arr[], int target) {
            int low = 0, high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target)
                    return true;
                // check if arr[low],arr[mid],arr[high] are same
                // if same then increment the pointer
                if (arr[low] == arr[mid] && arr[low] == arr[high]) {
                    low = low + 1;
                    high = high - 1;
                    continue;
                }
                // check if left half is sorted
                if (arr[low] <= arr[mid]) {
                    if (arr[low] <= target && target <= arr[mid])
                        high = mid - 1;
                    else
                        low = mid + 1;
                }
                // check if right is sorted
                else {
                    if (arr[mid] <= target && target <= arr[high])
                        low = mid + 1;
                    else
                        high = mid - 1;
                }
            }
            return false;
        }
    }
}
