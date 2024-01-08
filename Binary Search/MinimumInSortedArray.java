public class MinimumInSortedArray {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 1, 2 };
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(arr);
        System.out.println("Minimum element in the array is : " + bruteForce);
        int binarySearch = solution.binarySerach(arr);
        System.out.println("Minimum element in the array is : " + binarySearch);

    }

    private static class Solution {
        private int bruteForce(int arr[]) {
            int min = Integer.MAX_VALUE;
            for (int val : arr) {
                if (val < min)
                    min = val;
            }
            return min;
        }

        private int binarySerach(int arr[]) {
            int low = 0;
            int high = arr.length - 1;
            int min = Integer.MAX_VALUE;
            while (low <= high) {
                int mid = (low + high) / 2;
                // if the left half is sorted then find the minimum value of this and eliminate
                // the sorted half
                if (arr[low] <= arr[mid]) {
                    min = Math.min(min, arr[low]);
                    low = mid + 1;
                }
                // if the right half is sorted then find the minimum value of this and eliminate
                // the sorted half
                else {
                    min = Math.min(min, arr[mid]);
                    high = mid - 1;
                }
            }
            return min;
        }
    }
}
