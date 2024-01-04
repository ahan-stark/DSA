public class SearchInsertPosition {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 6, 7, 8, 9 };
        int elem = 5;
        Solution solution = new Solution();
        int pos = solution.sol(arr, elem);
        System.out.println("Element should be inserted at pos :" + pos);
    }

    private static class Solution {
        private int sol(int arr[], int ele) {
            // idea is similar to finding the lower bound of that element
            int low = 0, high = arr.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = (low + high)/2;
                if (ele <= arr[mid]) {
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
