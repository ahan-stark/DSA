public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7 };
        Solution solution = new Solution();
        // brute Force
        int unique = solution.bruteForce(arr);
        System.out.println("Unique element in the array is : " + unique);
        int binarySearch = solution.binarySearch(arr);
        System.out.println("Unique element using Binary Search is : " + binarySearch);
    }

    private static class Solution {
        private int bruteForce(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                if (arr.length == 1)
                    return arr[0];
                else if (i == 0) {
                    if (arr[i] != arr[i + 1])
                        return arr[i];
                } else if (i == arr.length - 1) {
                    if (arr[i] != arr[i - 1])
                        return arr[i];
                } else {
                    if (arr[i] != arr[i + 1] && arr[i] != arr[i - 1])
                        return arr[i];
                }
            }
            return 0;
        }

        private int binarySearch(int arr[]) {
            if (arr.length == 1)
                return arr[0];
            if (arr[0] != arr[1])
                return arr[0];
            if (arr[arr.length - 1] != arr[arr.length - 2])
                return arr[arr.length - 1];
            // we will in advance check the first and last element to avoid complication
            // inside the Binary Search
            int low = 1;
            int high = arr.length - 2;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
                    return arr[mid];
                // logic works like for the first even index element there will be a same
                // element in odd index, if the flow has changed as first element is in odd
                // index then the single element is before that index
                if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || mid % 2 == 0 && arr[mid] == arr[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    }
}
