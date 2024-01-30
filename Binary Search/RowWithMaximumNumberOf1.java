public class RowWithMaximumNumberOf1 {
    public static void main(String[] args) {
        int arr[][] = { { 0, 1, 1 }, { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(arr);
        System.out.println("Brute Force : " + bruteForce);
        int binarySearch = solution.binarySearch(arr);
        System.out.println("Binary Search : " + binarySearch);
    }

    private static class Solution {
        private int bruteForce(int arr[][]) {
            int current = 0;
            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                int count = 0;
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 1)
                        count++;
                }
                if (count > current) {
                    current = count;
                    index = i;
                }
            }
            return index;
        }

        private int binarySearch(int arr[][]) {
            int index = -1;
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                int sol = checkRows(arr[i]);
                // the binary search will return first occurence of 1
                // we can calculate total 1's using arr[0].length - val
                if ((arr[0].length - sol) > ans) {
                    ans = (arr[0].length - sol);
                    index = i;
                }
            }
            return index;
        }

        private int checkRows(int[] row) {
            int low = 0;
            int high = row.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (row[mid] >= 1) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
}