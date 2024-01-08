public class ArrayRotationCounter {
    public static void main(String[] args) {
        int arr[] = { 5, 6, 1, 2, 3, 4 };
        Solution solution = new Solution();
        int sol = solution.optimalSol(arr);
        System.out.println("Array is rotated : " + sol + " times");
    }

    private static class Solution {
        public int optimalSol(int[] arr) {
            int low = 0, high = arr.length - 1;
            int min = Integer.MAX_VALUE;
            int index = -1;
            // to find how many times the array is rotated just find where is the
            // minimum element
            while (low <= high) {
                int mid = (low + high) / 2;
                // if the left half is sorted then find the minimum value of this and eliminate
                // the sorted half
                if (arr[low] <= arr[mid]) {
                    if (arr[low] < min) {
                        min = arr[low];
                        index = low;
                    }
                    low = mid + 1;
                    // if the right half is sorted then find the minimum value of this and eliminate
                    // the sorted halfelse
                } else {
                    if (arr[mid] < min) {
                        min = arr[mid];
                        index = mid;
                    }
                    high = mid - 1;
                }
            }
            return index;
        }
    }
}
