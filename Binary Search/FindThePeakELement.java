public class FindThePeakELement {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 1 };
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(arr);
        System.out.println("Brute Force for peak index is  : " + bruteForce);
        int binarySearch = solution.binarySearch(arr);
        System.out.println("Binary Search for peak index is  : " + binarySearch);
    }

    private static class Solution {
        private int bruteForce(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                if ((i == 0 || arr[i - 1] < arr[i]) && (i == arr.length - 1 || arr[i] > arr[i + 1])) {
                    return i;
                }
            }
            return -1;
        }
        private int binarySearch(int arr[]) {
            if (arr.length == 1)
                return 0;
            if (arr[0] > arr[1])
                return 0;
            if (arr[arr.length - 1] > arr[arr.length - 2])
                return arr.length - 1;
            int low = 1;
            int high = arr.length - 2;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return mid;
                // if the order of elements is in increasing order then move right and check for
                // peak element
                if (arr[mid] > arr[mid - 1])
                    low = mid + 1;
                // else if the element is not in increasing order that means its already peaked
                // behind come back ways
                else
                    high = mid - 1;
            }
            return -1;
        }
    }
}
