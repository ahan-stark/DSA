public class ImplementingBS {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 7, 8, 9 };
        int target = 8;
        Solution solution = new Solution();
        int iterativeSol = solution.iterative(arr, target);
        System.out.println("Iterative Approach : " + iterativeSol);
        int recursiveSol = solution.recursive(arr, target);
        System.out.println("Recursive Approach : " + recursiveSol);
    }

    private static class Solution {
        private int iterative(int arr[], int target) {
            int low = 0, high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target)
                    return mid;
                else if (target > arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        private int recursive(int arr[], int target) {
            int low = 0, high = arr.length - 1;
            return recursiveSol(arr, low, high, target);
        }

        private int recursiveSol(int arr[], int low, int high, int target) {
            if (low > high)
                return -1;
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            else if (target > arr[mid])
                return recursiveSol(arr, mid + 1, high, target);
            else
                return recursiveSol(arr, low, mid - 1, target);
        }
    }
}